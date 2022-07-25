package jpa.api;

import jpa.domain.*;
import jpa.repository.OrderRepository;
import jpa.repository.order.query.OrderFlatDto;
import jpa.repository.order.query.OrderItemQueryDto;
import jpa.repository.order.query.OrderQueryDto;
import jpa.repository.order.query.OrderQueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.*;

/**
 * @OneToMany 관계 최적화
 * Order
 * Order -> OrderItems
 */
@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;

    /**
     * V1. 엔티티 직접 노출
     * - Hibernate5Module 모듈 등록, LAZY=null 처리
     * - 양방향 관계 문제 발생 -> @JsonIgnore
     * 문제
     * - 엔티티가 변하면 API 스펙이 변한다.
     * - 트랜잭션 안에서 지연 로딩 필요
     * - 양방향 연관관계 문제
     */
    @GetMapping("/api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName(); //Lazy 강제 초기화
            order.getDelivery().getAddress(); //Lazy 강제 초기환
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o -> o.getItem().getName()); //Lazy 강제 초기화
        }
        return all;
    }

    /**
     * V2. 엔티티를 조회해서 DTO로 변환(fetch join 사용X)
     * - 지연 로딩으로 너무 많은 SQL 실행
     * - 트랜잭션 안에서 지연 로딩 필요
     */
    @GetMapping("/api/v2/orders")
    public List<OrderDto> ordersV2() {
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(toList());
        return result;
    }

    /**
     * V3. 엔티티를 조회해서 DTO로 변환(fetch join 사용O)
     * - fetch join으로 쿼리 1번 호출(지연 로딩 X)
     * - 컬렉션 패치 조인은 1개만 사용
     * - distinct: 애플리케이션에서 중복 제거
     * 문제
     * - 페이징 불가능
     */
    @GetMapping("/api/v3/orders")
    public List<OrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(toList());
        return result;
    }

     /**
      * V3.1 엔티티를 조회해서 DTO로 변환, 페이징 고려
      * - @xxToOne 관계만 우선 모두 페치 조인으로 최적화
      * - 컬렉션 관계는 hibernate.default_batch_fetch_size(글로벌), @BatchSize(개별)로 최적화
      * 장점
      * - 쿼리 호출 수가 1 + N -> 1 + 1 로 최적화
      * - 조인보다 DB 데이터 전송량이 최적화
      * - 페치 조인 방식과 비교해서 쿼리 호출 수가 약간 증가하지만, DB 데이터 전송량이 감소
      * - 컬렉션 페치 조인은 페이징이 불가능 하지만 이 방법은 페이징이 가능
      * 결론
      * @xxToOne 페치조인으로 쿼리 수를 줄여 해결하고, 나머지는 hibernate.default_batch_fetch_size 로 최적화 하자
      */
     @GetMapping("/api/v3.1/orders")
     public List<OrderDto> ordersV3_page(
             @RequestParam(value = "offset", defaultValue = "0") int offset,
             @RequestParam(value = "limit", defaultValue = "100") int limit) {
         List<Order> orders = orderRepository.findAllWithMemberDelivery(offset, limit);
         List<OrderDto> result = orders.stream()
                 .map(o -> new OrderDto(o))
                 .collect(toList());
         return result;
     }

     /**
      * V4. JPA에서 DTO로 바로 조회, 컬렉션 N 조회 (1 + N Query)
      * - 페이징 가능
      */
     private final OrderQueryRepository orderQueryRepository;

     @GetMapping("/api/v4/orders")
     public List<OrderQueryDto> ordersV4() {
         return orderQueryRepository.findOrderQueryDtos();
     }

     /**
      * V5. JPA에서 DTO로 바로 조회, 컬렉션 1 조회 최적화 버전 (1 + 1 Query)
      * 일대다 관계인 컬렉션은 IN 절을 활용해서 메모리에 미리 조회해서 최적화
      * - 페이징 가능
      */
     @GetMapping("/api/v5/orders")
     public List<OrderQueryDto> ordersV5() {
         return orderQueryRepository.findAllByDto_optimization();
     }

     /**
      * V6. JPA에서 DTO로 바로 조회, 플랫 데이터(1Query) (1 Query)
      * 단점
      * - 쿼리는 한번이지만 조인으로 인해 DB에서 애플리케이션에 전달하는 데이터에 중복 데이터가 추가되므로 상황에 따라 V5 보다 더 느릴 수 도 있다.
      * - 애플리케이션에서 추가 작업이 크다.
      * - 페이징 불가능
      */
     @GetMapping("/api/v6/orders")
     public List<OrderQueryDto> ordersV6() {
         List<OrderFlatDto> flats = orderQueryRepository.findAllByDto_flat();

         return flats.stream()
                 .collect(groupingBy(o -> new OrderQueryDto(
                         o.getOrderId(), o.getName(), o.getOrderDate(), o.getOrderStatus(), o.getAddress()),
                         mapping(o -> new OrderItemQueryDto(
                                 o.getOrderId(), o.getItemName(), o.getOrderPrice(), o.getCount()), toList())
                 )).entrySet().stream()
                 .map(e -> new OrderQueryDto(
                         e.getKey().getOrderId(), e.getKey().getName(), e.getKey().getOrderDate(),
                         e.getKey().getOrderStatus(),e.getKey().getAddress(), e.getValue()))
                 .collect(toList());
     }

    @Data
    static class OrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;
        private List<OrderItemDto> orderItems;

        public OrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();
            orderItems = order.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDto(orderItem))
                    .collect(toList());
        }
    }

    @Data
    static class OrderItemDto {
        private String itemName;//상품 명
        private int orderPrice; //주문 가격
        private int count; //주문 수량

        public OrderItemDto(OrderItem orderItem) {
            itemName = orderItem.getItem().getName();
            orderPrice = orderItem.getOrderPrice();
            count = orderItem.getCount();
        }
    }
}
