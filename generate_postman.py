import json

collection = {
    "info": {
        "name": "BadaBazaar",
        "description": "Postman Collection for BadaBazaar APIs",
        "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "variable": [
        {
            "key": "base_url",
            "value": "http://localhost:8080",
            "type": "string"
        },
        {
            "key": "token",
            "value": "",
            "type": "string"
        }
    ],
    "item": [
        {
            "name": "Auth",
            "item": [
                {
                    "name": "Register",
                    "request": {
                        "method": "POST",
                        "header": [{"key": "Content-Type", "value": "application/json"}],
                        "body": {
                            "mode": "raw",
                            "raw": "{\n  \"name\": \"John Doe\",\n  \"email\": \"john@example.com\",\n  \"password\": \"password\",\n  \"role\": \"CUSTOMER\"\n}"
                        },
                        "url": {"raw": "{{base_url}}/v1/auth/register", "host": ["{{base_url}}"], "path": ["v1", "auth", "register"]}
                    }
                },
                {
                    "name": "Login",
                    "request": {
                        "method": "POST",
                        "header": [{"key": "Content-Type", "value": "application/json"}],
                        "body": {
                            "mode": "raw",
                            "raw": "{\n  \"email\": \"john@example.com\",\n  \"password\": \"password\"\n}"
                        },
                        "url": {"raw": "{{base_url}}/v1/auth/login", "host": ["{{base_url}}"], "path": ["v1", "auth", "login"]}
                    }
                }
            ]
        },
        {
            "name": "Admin",
            "item": [
                {
                    "name": "Get users by role",
                    "request": {
                        "method": "GET",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"}
                        ],
                        "url": {
                            "raw": "{{base_url}}/v1/admin?role=CUSTOMER",
                            "host": ["{{base_url}}"],
                            "path": ["v1", "admin"],
                            "query": [{"key": "role", "value": "CUSTOMER"}]
                        }
                    }
                }
            ]
        },
        {
            "name": "Cards",
            "item": [
                {
                    "name": "Add card",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"},
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\n  \"customerId\": 1,\n  \"cardNumber\": \"1234567890123456\",\n  \"expiryDate\": \"12/26\",\n  \"cvv\": \"123\"\n}"
                        },
                        "url": {"raw": "{{base_url}}/v1/cards", "host": ["{{base_url}}"], "path": ["v1", "cards"]}
                    }
                },
                {
                    "name": "Get all cards",
                    "request": {
                        "method": "GET",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"}
                        ],
                        "url": {"raw": "{{base_url}}/v1/cards/1", "host": ["{{base_url}}"], "path": ["v1", "cards", "1"]}
                    }
                },
                {
                    "name": "Remove card",
                    "request": {
                        "method": "DELETE",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"}
                        ],
                        "url": {"raw": "{{base_url}}/v1/cards/1/customer/1", "host": ["{{base_url}}"], "path": ["v1", "cards", "1", "customer", "1"]}
                    }
                }
            ]
        },
        {
            "name": "Carts",
            "item": [
                {
                    "name": "Add product to cart",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"},
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\n  \"productId\": 1,\n  \"quantity\": 2\n}"
                        },
                        "url": {"raw": "{{base_url}}/v1/carts", "host": ["{{base_url}}"], "path": ["v1", "carts"]}
                    }
                },
                {
                    "name": "Get all products in cart",
                    "request": {
                        "method": "GET",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"}
                        ],
                        "url": {"raw": "{{base_url}}/v1/carts/1", "host": ["{{base_url}}"], "path": ["v1", "carts", "1"]}
                    }
                },
                {
                    "name": "Checkout cart",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"}
                        ],
                        "url": {
                            "raw": "{{base_url}}/v1/carts/1?cardId=1",
                            "host": ["{{base_url}}"],
                            "path": ["v1", "carts", "1"],
                            "query": [{"key": "cardId", "value": "1"}]
                        }
                    }
                }
            ]
        },
        {
            "name": "Items",
            "item": [
                {
                    "name": "View product",
                    "request": {
                        "method": "GET",
                        "header": [],
                        "url": {"raw": "{{base_url}}/v1/items/1", "host": ["{{base_url}}"], "path": ["v1", "items", "1"]}
                    }
                }
            ]
        },
        {
            "name": "Orders",
            "item": [
                {
                    "name": "Place order",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"},
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\n  \"productId\": 1,\n  \"quantity\": 2\n}"
                        },
                        "url": {"raw": "{{base_url}}/v1/orders", "host": ["{{base_url}}"], "path": ["v1", "orders"]}
                    }
                }
            ]
        },
        {
            "name": "Products",
            "item": [
                {
                    "name": "Add product",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"},
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\n  \"name\": \"Laptop\",\n  \"description\": \"Gaming Laptop\",\n  \"price\": 1200,\n  \"quantity\": 10,\n  \"category\": \"ELECTRONICS\",\n  \"sellerId\": 1\n}"
                        },
                        "url": {"raw": "{{base_url}}/v1/products", "host": ["{{base_url}}"], "path": ["v1", "products"]}
                    }
                },
                {
                    "name": "Update product",
                    "request": {
                        "method": "PUT",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"},
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\n  \"id\": 1,\n  \"name\": \"Laptop\",\n  \"description\": \"Upgraded Gaming Laptop\",\n  \"price\": 1300,\n  \"quantity\": 8,\n  \"category\": \"ELECTRONICS\",\n  \"sellerId\": 1\n}"
                        },
                        "url": {"raw": "{{base_url}}/v1/products", "host": ["{{base_url}}"], "path": ["v1", "products"]}
                    }
                },
                {
                    "name": "Get products by sellerId",
                    "request": {
                        "method": "GET",
                        "header": [],
                        "url": {"raw": "{{base_url}}/v1/products/1", "host": ["{{base_url}}"], "path": ["v1", "products", "1"]}
                    }
                },
                {
                    "name": "Get products by category",
                    "request": {
                        "method": "GET",
                        "header": [],
                        "url": {"raw": "{{base_url}}/v1/products/category/ELECTRONICS", "host": ["{{base_url}}"], "path": ["v1", "products", "category", "ELECTRONICS"]}
                    }
                },
                {
                    "name": "Remove product",
                    "request": {
                        "method": "DELETE",
                        "header": [
                            {"key": "Authorization", "value": "Bearer {{token}}"}
                        ],
                        "url": {"raw": "{{base_url}}/v1/products/1", "host": ["{{base_url}}"], "path": ["v1", "products", "1"]}
                    }
                }
            ]
        }
    ]
}

with open("BadaBazaar_Postman_Collection.json", "w") as f:
    json.dump(collection, f, indent=2)

