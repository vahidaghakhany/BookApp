#  Sample Android Book App

A simple Android application that displays a list of books fetched from an open RESTful API.  
The project follows **Clean Architecture**, **Modularization**, and **MVVM**, making it easy to scale, test, and maintain.

Built using **Jetpack Compose**, **Hilt**, **RxJava**, and Android modern development best practices.

---

##  Features

- Fetch list of books from an open REST API  
- Modern UI built with **Jetpack Compose**  
- Reactive async operations using **RxJava**  
- Dependency Injection with **Hilt**  
- Clean Architecture + MVVM  
- Modular project structure  
- Loading & error handling  

---

##  Project Architecture

This project is organized using **Clean Architecture** and modularized into four modules:


### **Domain Module**
- Business logic  
- Entities & UseCases  
- Repository interfaces  

### **Data Module**
- Repository implementation  
- Remote data source 
- DTO-to-domain model mapping
- DTOs

### **Network Module**
- Retrofit API services  
- OkHttp configurations  

### **App (Presentation) Module**
- Jetpack Compose UI  
- MVVM ViewModels  
- Hilt DI setup  

---

##  Tech Stack

### **Languages & Frameworks**
- Kotlin
- Jetpack Compose  
- MVVM

### **Libraries**
- Hilt (Dependency Injection)  
- RxJava (Asynchronous operations)  
- Retrofit & OkHttp (Networking)  
- Material

### **Architecture**
- Clean Architecture  
- Multi-module project  
- Reactive UI and data flow



