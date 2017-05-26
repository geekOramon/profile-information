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