# spring-boot-jpa-mysql-movies-crud

# Create
# Request type: POST
# Content-type=applciation/json
# http://localhost:8080/movies/create

# Input:
{
	"dataObj" : [
		{
		    "name": "Race-3",
		    "yearOfRelease": "2018",
		    "description": "Action Drama movie",
		    "language": "Hindi",
		    "poster": "/images/race3_poster.jpeg"
		},
		{

		    "name": "Baaghi-2",
		    "yearOfRelease": "2018",
		    "description": "Action movie",
		    "language": "Hindi",
		    "poster": "/images/Baaghi2_poster.jpeg"
		}
	]
}

# Read
# Request type: GET
# Content-type=applciation/json
# http://localhost:8080/movies
# http://localhost:8080/movies/54

# Update
# Request type: PUT
# Content-type=applciation/json
# http://localhost:8080/movies/update

# Input:
{
	"dataObj" : [
		{
			"movieId": 53,
		    "name": "Race-3",
		    "yearOfRelease": "2018",
		    "description": "Drama Thriller movie",
		    "language": "Hindi",
		    "poster": "/images/race3_poster.jpeg"
		},
		{
		    "movieId": 54,
		    "name": "Baaghi-2",
		    "yearOfRelease": "2018",
		    "description": "Action Thriller movie",
		    "language": "Hindi",
		    "poster": "/images/Baaghi2_poster.jpeg"
		}
	]
}

# Delete
# Request type: DELETE
# Content-type=applciation/json
# http://localhost:8080/movies/{movieId}
