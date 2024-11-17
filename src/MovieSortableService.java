public interface MovieSortableService {

    public interface movieSortableService {
        void sortMovieByName(String ascOrDesc);
        void sortByYear(String ascOrDesc);
        void sortByProducer(String nameOrLastName);
    }

}
