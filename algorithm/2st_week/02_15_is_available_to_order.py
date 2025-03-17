shop_menus = ["만두", "떡볶이", "오뎅", "사이다", "콜라"]
shop_orders = ["오뎅", "콜라", "만두"]


def is_available_to_order(menus, orders):
    '''
    shop_menus.sort()

    for order in shop_orders:
        current_min = 0
        current_max = len(shop_menus) - 1
        current_guess = (current_min + current_max) // 2

        is_available = False
        while current_min <= current_max and not is_available:
            if order == shop_menus[current_guess]:
                is_available = True
            elif order < shop_menus[current_guess]:
                current_max = current_guess - 1
            else:
                current_min = current_guess + 1
            current_guess = (current_min + current_max) // 2

        if not is_available:
            return False

    return True
    '''

    # O((N+M)*log(N))
    menus.sort() # O(NlogN)
    for order in orders: # O(M)
        if not is_existing_target_number_binary(order, menus): # O(logN)
            return False
    return True

def is_existing_target_number_binary(target, array):
    current_min = 0
    current_max = len(array) - 1
    current_guess = (current_min + current_max) // 2

    while current_min <= current_max:
        if array[current_guess] == target:
            return True
        elif array[current_guess] < target:
            current_min = current_guess + 1
        else: # array[current_guess] > target
            current_max = current_guess - 1
        current_guess = (current_min + current_max) // 2

    return False

result = is_available_to_order(shop_menus, shop_orders)
print(result)