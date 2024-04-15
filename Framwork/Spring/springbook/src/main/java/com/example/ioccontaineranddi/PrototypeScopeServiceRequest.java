package com.example.ioccontaineranddi;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

public class PrototypeScopeServiceRequest {

    @Component
    @Scope("prototype")
    static class ServiceRequest {
         String customerNo; // 폼에서 입력받은 고객번호를 저장할 프로퍼티
        Customer customer; // customerNo 값 대신 Customer 오브젝트 자체를 갖고 있게 한다.
        String productNo;
        String description;

        @Autowired CustomerDao customerDao;
        @Autowired EmailService emailService;

        public String getCustomerNo() {
            return customerNo;
        }

        public void setCustomerNo(String custno) {
            this.customerNo = custno;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        // 전달받은 customerNo를 customerDao를 이용해 Customer 오브젝트로 변환해서 저장한다.
        public void setCustomerByCustomerNo(String customerNo) {
            this.customer = customerDao.findCustomerByNo(customerNo);
        }

        public void setCustomerByCustomerId(int customerId) {
            this.customer = customerDao.getCustomer(customerId);
        }

        // A/S 요청이 등록됐음을 통보해주는 기능을 가진 메소드
        public void notifyServiceRequestRegistration() {
            if (this.customer.serviceNotificationMethod == NotificationMethod.EMAIL) {
                this.emailService.sendEmail(customer.getEmail(), "A/S 접수가 정상적으로 처리되었습니다.");
            }
        }
    }

    static abstract class ServiceRequestController {

        private ServiceRequestService serviceRequestService;
//        @Autowired ApplicationContext context;
//        @Autowired ServiceRequest serviceRequest;

//        @Resource // ObjectFactory 타입은 여러 개 있을 수 있으므로 이름으로 빈을 지정하는 편이 낫다.
//        private ObjectFactory<ServiceRequest> serviceRequestFactory;

//        @Autowired
//        ServiceRequestFactory serviceRequestFactory;

//        abstract public ServiceRequest getServiceRequest();

        @Autowired
        Provider<ServiceRequest> serviceRequestProvider;

        public void serviceRequestFormSubmit(HttpServletRequest request) {
            // ServiceRequest serviceRequest = new ServiceRequest(); // 매 요청마다 새로운 ServiceRequest 오브젝트를 생성한다.

            // ApplicationContext, BeanFactory를 DI 받은 뒤에 getBean() 메소드를 직접 호출
//            ServiceRequest serviceRequest = this.context.getBean(ServiceRequest.class);

            // 컨트롤러에 DI 하기 위해 컨테이너에 요청할 때 딱 한번만 오브젝트가 생성되고 더 이상 새로운 ServiceRequest 오브젝트는 만들어지지 않는다.
//            this.serviceRequest.setCustomerNo(request.getParameter("custno"));

            // ObjectFactory의 사용
//            ServiceRequest serviceRequest = this.serviceRequestFactory.getObject();

            // 팩토리 인터페이스 사용
//            ServiceRequest serviceRequest = this.serviceRequestFactory.getServiceFactory();

            // 메소드 주입
//            ServiceRequest serviceRequest = this.getServiceRequest();

            // Provider<T>
            ServiceRequest serviceRequest = serviceRequestProvider.get();

            serviceRequest.setCustomerNo(request.getParameter("custno"));
            this.serviceRequestService.addNewServiceRequest(serviceRequest);
        }
    }

    static class ServiceRequestService {

        private CustomerDao customerDao;
        private ServiceRequestDao serviceRequestDao;
        private EmailService emailService;

        public void addNewServiceRequest(ServiceRequest serviceRequest) {
            // Customer customer = this.customerDao.findCustomerByNo(serviceRequest.getCustomerNo()); // 폼에서 입력받은 고객번호를 이용해 Customer 오브젝트를 가져온다.
//            this.emailService.sendEmail(customer.getEmail(), "A/S 접수가 정상적으로 처리되었습니다.");

            this.serviceRequestDao.add(serviceRequest);
//            this.emailService.sendEmail(serviceRequest.getCustomer().getEmail(), "A/S 접수가 정상적으로 처리되었습니다.");
            serviceRequest.notifyServiceRequestRegistration(); // 구체적인 통보 작업은 ServiceRequest에서 알아서 담당하게 한다.
        }
    }

    @Component
    static class EmailService {
        public void sendEmail(String email, String msg) {

        }
    }

    static class ServiceRequestDao {
        public void add(ServiceRequest serviceRequest, Customer customer) {}
        public void add(ServiceRequest serviceRequest) {}
    }

    @Component
    static class CustomerDao {
        public Customer findCustomerByNo(String customerNo) {
            return new Customer();
        }

        public Customer getCustomer(int customerId) {
            return new Customer();
        }
    }

    static class Customer {
        private String email;

        NotificationMethod serviceNotificationMethod;

        public String getEmail() {
            return email;
        }
    }

    static enum NotificationMethod {
        EMAIL
    }
}
