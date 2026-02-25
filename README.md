# Securin Weather API

A robust Spring Boot application that processes weather data from CSV files, stores it in MongoDB Atlas, and provides a RESTful API for efficient data retrieval with pagination, sorting, and filtering capabilities.

## 🚀 Features

- **Automated Data Loading**: Automatically parses and imports weather data from local CSV files on startup using `CommandLineRunner`.
- **Advanced Querying**: Retrieve weather records with support for:
  - **Pagination**: Handle large datasets efficiently.
  - **Sorting**: Order data by any field (e.g., temperature, timestamp).
  - **Filtering**: Filter records by temperature ranges (min/max).
- **MongoDB Atlas Integration**: Scalable cloud-based storage.
- **Efficient CSV Parsing**: Uses OpenCSV for high-performance data extraction.

## 🛠️ Tech Stack

- **Backend**: Java 17+, Spring Boot 3.x
- **Database**: MongoDB (Atlas)
- **Libraries**:
  - `Lombok`: To reduce boilerplate code.
  - `Spring Data MongoDB`: For database operations.
  - `OpenCSV`: For CSV file processing.
  - `Spring Web`: For building RESTful APIs.

## 📋 Prerequisites

- **JDK 17** or higher
- **Maven 3.6+**
- **MongoDB Atlas Account** (or a local MongoDB instance)
- **Postman** (for API testing)

## ⚙️ Configuration

1. **Database Setup**:
   Update the `src/main/resources/application.properties` with your MongoDB connection string:
   ```properties
   spring.data.mongodb.uri=your_mongodb_atlas_connection_string
   server.port=8081
   ```

2. **CSV Path**:
   Ensure the CSV file path is correctly configured in `DataLoader.java`:
   ```java
   String filePath = "path/to/your/testset.csv";
   ```

## 🏃 Running the Application

Clone the repository:
```bash
git clone https://github.com/RATHAN005/Securin-WeatherAPI.git
cd Securin-WeatherAPI
```

Run using Maven:
```bash
mvn spring-boot:run
```

The server will start on `http://localhost:8081`.

## 📂 API Endpoints

### Get Weather Data
`GET /api/weather`

**Query Parameters:**
| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `page` | `int` | `0` | Page number to retrieve. |
| `size` | `int` | `10` | Number of records per page. |
| `sortBy` | `string` | `datetimeUtc` | Field name to sort by. |
| `direction` | `string` | `asc` | Sort direction (`asc` or `desc`). |
| `minTemp` | `double` | - | Minimum temperature filter. |
| `maxTemp` | `double` | - | Maximum temperature filter. |

**Example Request:**
```http
GET http://localhost:8081/api/weather?page=0&size=5&minTemp=10&maxTemp=25&sortBy=tempm&direction=desc
```

## 🧪 Testing with Postman

A Postman collection is included in the root directory: `weather_api_postman_collection.json`.
1. Open Postman.
2. Click **Import**.
3. Choose the `.json` file from this project.
4. Use the `baseUrl` variable to start testing.

## 🏗️ Project Structure

```text
weather-api/
├── src/
│   ├── main/
│   │   ├── java/com/securin/weather_api/
│   │   │   ├── config/       # Configuration and DataLoader
│   │   │   ├── controller/   # REST Controllers
│   │   │   ├── entity/       # MongoDB Documents
│   │   │   ├── repository/   # Data Access Layer
│   │   │   ├── service/      # Business Logic
│   │   │   └── util/         # CSV Parsing Utility
│   │   └── resources/
│   │       └── application.properties
│   └── test/                 # Unit and Integration Tests
├── pom.xml                   # Maven Dependencies
└── weather_api_postman_collection.json
```

## OUTPUT

<img width="1915" height="1049" alt="Screenshot 2026-02-25 141949" src="https://github.com/user-attachments/assets/1d9fe2eb-ba07-477d-afec-fb83d454c04a" />
<img width="1915" height="1056" alt="Screenshot 2026-02-25 115819" src="https://github.com/user-attachments/assets/1cb775fc-e8b8-4bee-bca5-34f369504d2b" />


## 📝 License
This project is developed for Securin assessment purposes.

