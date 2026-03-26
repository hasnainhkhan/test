# Portfolio Admin Starter (React + Spring Boot + MySQL)

Ye starter aapke `frontend-portfolio` ko admin-enabled banane ke liye banaya gaya hai.

## Features
- Nav title, hero title, hero description ke upar edit buttons.
- Inline edit karke save karte hi Spring Boot API call hoti hai.
- Data MySQL table `site_content` me persist hota hai.
- Theme color picker (color editable) + backend me save.

## Run Backend
```bash
cd backend
mvn spring-boot:run
```

## Run Frontend
```bash
cd frontend
npm install
npm run dev
```

## Important
Original GitHub repo network restriction ke wajah se clone nahi ho saka, isliye yaha ek plug-in starter diya gaya hai.
Aap iske components (`EditableField`, API service, backend endpoints) ko directly apne existing UI me merge kar sakte ho.
