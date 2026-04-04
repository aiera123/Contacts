# Contacts

📌 **Description**  

**Contacts** is a simple Android application developed using Java that allows users to store and manage contact information. 
The app provides basic contact management features such as adding, viewing, updating, and deleting contacts, with alphabetical sorting and a clean, modern UI.


🚀 **Features**  
-  Add new contacts  
-  Edit existing contacts  
-  View all saved contacts  
-  Delete contacts  
-  Alphabetical sorting (A–Z)  
-  Simple and responsive UI  
-  RecyclerView implementation  
-  Local storage with SQLite  

🛠 **Tech Stack**  
- **Language:** Java  
- **Database:** SQLite  
- **UI Components:** RecyclerView, FloatingActionButton  
- **IDE:** Android Studio  

---

📂 **Project Structure**  
app/
├── manifests/
│ └── AndroidManifest.xml
├── java/com/example/contact/
│ ├── activities/
│ │ ├── MainActivity.java
│ │ └── AddEditContactActivity.java
│ ├── adapter/
│ │ └── ContactAdapter.java
│ └── database/
│ └── DBHelper.java
└── res/
├── layout/
│ ├── activity_main.xml
│ ├── activity_add_edit.xml
│ └── item_contact.xml
└── drawable/

🚀 Key Implementation Highlights
MVVM-like separation using Activities, Model, Adapter, and Database Helper
Background thread execution using AppExecutor to prevent UI blocking
Live avatar preview in Add/Edit screen using TextWatcher
Deterministic avatar colors based on contact ID
Real-time search with SearchView and onQueryTextChange
Input validation (First name & Phone required, Email format check)
Intent handling for calling and sending email directly from app
🗄️ Database Schema
Table: contacts

id → INTEGER PRIMARY KEY AUTOINCREMENT
first_name → TEXT NOT NULL
last_name → TEXT
company → TEXT
phone → TEXT NOT NULL
email → TEXT
