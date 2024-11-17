

    import java.time.LocalDate;
import java.util.*;

    public class MovieService {

        public class movieService implements MovieFindableService, MovieSortableService {
            private List<Movie> movies;

            public movieService(List<Movie> movies) {
                this.movies = movies;
            }

            @Override
            public List<Movie> getAllMovies() {
                return new ArrayList<>(movies);
            }

            @Override
            public Movie findMovieByFullNameOrPartName(String name) {
                return movies.stream()
                        .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                        .findFirst()
                        .orElse(null);
            }

            @Override
            public Movie findMovieByActorName(String actorName) {
                return movies.stream()
                        .filter(movie -> movie.getActors().stream()
                                .anyMatch(actor -> actor.getActorFullName().equalsIgnoreCase(actorName)))
                        .findFirst()
                        .orElse(null);
            }

            @Override
            public Movie findMovieByYear(LocalDate year) {
                return movies.stream()
                        .filter(movie -> movie.getYear().equals(year))
                        .findFirst()
                        .orElse(null);
            }

            @Override
            public Movie findMovieByProducer(String producerFullName) {
                return movies.stream()
                        .filter(movie -> movie.getProducer().getFullName().equalsIgnoreCase(producerFullName))
                        .findFirst()
                        .orElse(null);
            }

            @Override
            public Movie findMovieByGenre(Genre genre) {
                return movies.stream()
                        .filter(movie -> movie.getGenre() == genre)
                        .findFirst()
                        .orElse(null);
            }

            @Override
            public Movie findMovieByRole(String role) {
                return movies.stream()
                        .filter(movie -> movie.getActors().stream()
                                .anyMatch(actor -> actor.getRole().equalsIgnoreCase(role)))
                        .findFirst()
                        .orElse(null);
            }

            @Override
            public void sortMovieByName(String ascOrDesc) {
                movies.sort(Comparator.comparing(Movie::getName));
                if ("desc".equalsIgnoreCase(ascOrDesc)) {
                    Collections.reverse(movies);
                }
            }

            @Override
            public void sortByYear(String ascOrDesc) {
                movies.sort(Comparator.comparing(Movie::getYear));
                if ("desc".equalsIgnoreCase(ascOrDesc)) {
                    Collections.reverse(movies);
                }
            }

            @Override
            public void sortByProducer(String nameOrLastName) {
                movies.sort(Comparator.comparing(movie -> {
                    Producer producer = movie.getProducer();
                    return "firstName".equalsIgnoreCase(nameOrLastName) ;

                }));
            }
        }
    }



