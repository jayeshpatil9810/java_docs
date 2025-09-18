
# Shopping cart Web Application

This project is based on Shopping App using Java, Spring Boot, MySQL and Hibernate. The main goal of this project is to create a series of backend API’s so that the user can access the functionalities of the various types of functions of the models just like the functionalities one can get while shopping from any online website. 

The system includes user management, allowing users to register, log in, and update their profiles securely. A product management module enables users to browse a product catalog, view product details, and add items to their shopping cart, where they can edit and eventually proceed to payment. Effective search capabilities aid users in finding specific products quickly. Payment processing is seamlessly integrated, ensuring secure transactions. Users can also manage wishlists and apply coupon codes for discounts.


## TechStacks and Tools
Application server – Apache Tomcat(version -11)

MySQL Workbench (Version - 8.0)​

Spring Boot (Version - 2.5)​

Eclipse (Version - 3.0)​

Postman(Version-10.18.10)

JDK (Version - 1.8)​

Hibernate Jpa

Payment Integration - Paypal

## Features
User Account Creation: Users can register and log in securely to manage their accounts.

Product Management: Manage a diverse range of products, including addition, update, and removal.

Shopping Cart: Add, edit, and remove products from the cart before making a purchase.

Search Functionality: Search for products based on different parameters.

Secure Payment System: Allows secure and hassle-free payments for the products.

Wishlist Management: Save desired products for future purchases.

Coupon Application: Apply discount coupons during checkout for savings.


## Project Setup
1.Clone the repository: git clone https://github.com/v2dev/java-pocs.git

2.Change database connection config in src/main/resources/application.properties

3.Install maven dependencies using IDE auto import or using the command mvn install

4.Build the project- mvn clean install package

5.Run the app using mvn spring-boot:start from project root directory.
## Endpoints to access the Functionalities
To register as a user:
http://localhost:9091/api/users/register

To login as a user:
http://localhost:9091/api/users/login

To add new products
http://localhost:8082/api/product/add

To add products to cart:
http://localhost:9092/addProduct

To search the product:
http://localhost:8082/api/search?search=mobile

To save in wishlist:
http://localhost:8080/wishlist/addproduct 

To apply coupon:
http://localhost:8081/api/coupons/apply?couponCode=ZXCV3A&totalAmount=1000&userId=110

To make payment:

create payment : http://localhost:8080/paypal/init?sum=35&userId=1

redirectUrl for payment approval : "https://www.sandbox.paypal.com/checkoutnow?token=6M7134432A2991456"

complete payment : http://localhost:8080/paypal/capture/{userId}/{coupon}
PayPal




## Usage
1.Upon starting the application, users can register or log in to access the platform's functionalities.

2.They can explore a wide range of products, add items to the cart and make secure payments.

3.Users can manage their accounts, wishlists, apply available discount coupons.