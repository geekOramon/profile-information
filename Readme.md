Profile Information


API

GET uri/user -> get all users

GET uri/user/email -> get the user inserted with this email

POST uri/user and json like this

    {
      "name":"lola",
      "surName":"ruperta",
      "email":"rupertolola@yopmail.com",
      "phone":"65656",
      "password":"empty"
    }
    
Environment variables

    * config_server_uri -> http://user:password@uri:port
    * app_profile -> (dev, qa, prod)
    
    http://profile-service-config-developer:kaioken@localhost:8888/profile-service-config/dev
    
    
Docker run:

    docker run -e config_server_uri=http://profile-service-config-developer:kaioken@localhost:8888 -e app_profile=dev --net=my_network -p 8080:8080 springio/profile-information