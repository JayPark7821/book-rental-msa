curl -X POST "http://localhost:8082/api/member" -H "accept: */*" -H "Content-Type: application/json" -d "{\"address\":
\"scant10@gmail.com\",\"id\":\"jenny\", \"name\":\"제니\",\"passPwd\":\"1111\"}"

curl -X POST "http://localhost:8081/api/book" -H "accept: */*" -H "Content-Type: application/json" -d "{\"author\":
\"한정헌\",\"classification\": \"LITERATURE\",\"description\":\"고전 소설\",\"isbn\":\"1232141214\", \"location\":
\"JEONGJA\",\"publicationDate\":\"2023-02-11\",\"source\": \"SUPPLY\",\"title\":\"누구를 위하여 종을 울리나?\"}"

curl -X GET "http://localhost:8081/api/book/1" -H "accept: */*"

curl -X POST "http://localhost:8080/api/rental-card" -H "accept: */*" -H "Content-Type: application/json" -d "{\"userId\":\"jenny\",\"userName\":\"제니\"}"

curl -X POST "http://localhost:8080/api/rental-card/rent" -H "accept: */*" -H "Content-Type: application/json" -d "{\"itemId\":1,\"itemTitle\":\"누구를 위하여 종 을 울리나?\",\"userId\":\"jenny\",\"userName\":\"제니\"}"

curl -X GET "http://localhost:8081/api/book/1" -H "accept: */*"

curl -X GET "http://localhost:8082/api/member/1" -H "accept: */*"

curl -X GET "http://localhost:8084/api/books" -H "accept: */*"

curl -X POST "http://localhost:8080/api/rental-card/return" -H "accept: */*" -H "Content-Type: application/json" -d "{\"itemId\":1,\"itemTitle\":\"누구를 위하여 종 을 울리나?\",\"userId\":\"jenny\",\"userName\":\"제니\"}"

curl -X GET "http://localhost:8081/api/book/1" -H "accept: */*"

curl -X GET "http://localhost:8082/api/member/1" -H "accept: */*"