Add product to cart:
http://localhost:8082/proceed/add

body
{
    "customerId":41,
    "productId":1,
    "zipCode":712104,
    "expectedDeliveryDate":"02/11/2020"
}

--------------------------------------
add to wishlist
http://localhost:8082/proceed/wishlist/41/2/5
--------------------------------------------
remove from cart
http://localhost:8082/proceed/delete/41/1