# Build

```bash
mvn clean package
```
# Run

```bash
java -jar target/hlulani-mhlongo-0.0.1-SNAPSHOT.jar
```

# Requests

### Getting Distance from

```bash
curl http://localhost:8080/milkyway/shortest-distance?from=A&to=H
```
### CRUD
```bash
# Create Planet
$ curl -d '{"name": "AA",	"description": "Super Earth"}' -H "Content-Type: application/json" -X POST http://localhost:8080/planets

# List Planes
$ curl http://localhost:8080/planets

# New Route/Path
$ curl -d '{ "id": 50, "origin": { "name": "AA", "description": "New Planet"}, "destination": {	"name": "L'", "description": "Captain Planet"}, "distance": 50}' -H "Content-Type: application/json" -X POST http://localhost:8080/milkyway
```

# Improvements
- cater for cases where there is no way to get to a spacific planet
- Add Pagination for APIs that list items
- Use surrogate keys for Item creation
- API input validation
- More Testing
