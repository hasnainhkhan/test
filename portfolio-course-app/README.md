# Portfolio + Course App (Spring Boot)

This starter includes:
- Portfolio API endpoints (`/`, `/portfolio`)
- Spring Security with OAuth2 login (Google sample)
- Razorpay order creation API (`POST /api/course/order`)
- WhatsApp bot message hook (`POST /api/course/notify`)

## Run
```bash
mvn spring-boot:run
```

## Example requests
```bash
curl -X POST http://localhost:8080/api/course/order \
  -H "Content-Type: application/json" \
  -d '{"amount":"49900","receiptId":"course-order-101"}'

curl -X POST http://localhost:8080/api/course/notify \
  -H "Content-Type: application/json" \
  -d '{"phone":"919999999999","course":"Java Spring Masterclass"}'
```

Update secrets through environment variables before production deployment.
