package linkedlist;
import java.util.ArrayList;
import java.util.List;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;
    
    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;
    private int count;
    
    MovieLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    
    void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (this.head == null) {
            this.head = newMovie;
            this.tail = newMovie;
        } else {
            newMovie.next = this.head;
            this.head.prev = newMovie;
            this.head = newMovie;
        }
        this.count++;
    }
    
    void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (this.head == null) {
            this.head = newMovie;
            this.tail = newMovie;
        } else {
            newMovie.prev = this.tail;
            this.tail.next = newMovie;
            this.tail = newMovie;
        }
        this.count++;
    }
    
    void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        
        if (position >= this.count) {
            addAtEnd(title, director, year, rating);
            return;
        }
        
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        MovieNode current = this.head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        newMovie.prev = current.prev;
        newMovie.next = current;
        current.prev.next = newMovie;
        current.prev = newMovie;
        this.count++;
    }
    
    boolean removeByTitle(String title) {
        if (this.head == null) {
            return false;
        }
        
        MovieNode current = this.head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current == this.head) {
                    this.head = current.next;
                    if (this.head != null) {
                        this.head.prev = null;
                    } else {
                        this.tail = null;
                    }
                } else if (current == this.tail) {
                    this.tail = current.prev;
                    this.tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                this.count--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    List<MovieNode> searchByDirector(String director) {
        List<MovieNode> results = new ArrayList<>();
        MovieNode current = this.head;
        while (current != null) {
            if (current.director.equals(director)) {
                results.add(current);
            }
            current = current.next;
        }
        return results;
    }
    
    List<MovieNode> searchByRating(double rating) {
        List<MovieNode> results = new ArrayList<>();
        MovieNode current = this.head;
        while (current != null) {
            if (current.rating == rating) {
                results.add(current);
            }
            current = current.next;
        }
        return results;
    }
    
    void displayForward() {
        if (this.head == null) {
            System.out.println("No movies in the list");
            return;
        }
        
        MovieNode current = this.head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + 
                             ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }
    
    void displayReverse() {
        if (this.tail == null) {
            System.out.println("No movies in the list");
            return;
        }
        
        MovieNode current = this.tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + 
                             ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
    
    boolean updateRating(String title, double newRating) {
        MovieNode current = this.head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

public class MovieManagement {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();
        
        movieList.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("The Shawshank Redemption", "Frank Darabont", 1994, 9.3);
        movieList.addAtPosition(1, "Pulp Fiction", "Quentin Tarantino", 1994, 8.9);
        movieList.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        
        System.out.println("Movies in forward order:");
        movieList.displayForward();
        
        System.out.println("\nMovies in reverse order:");
        movieList.displayReverse();
        
        System.out.println("\nSearching for movies by director Christopher Nolan:");
        List<MovieNode> nolanMovies = movieList.searchByDirector("Christopher Nolan");
        for (MovieNode movie : nolanMovies) {
            System.out.println("Found: " + movie.title);
        }
        
        System.out.println("\nSearching for movies with rating 9.0:");
        List<MovieNode> highRated = movieList.searchByRating(9.0);
        for (MovieNode movie : highRated) {
            System.out.println("Found: " + movie.title);
        }
        
        System.out.println("\nUpdating rating for Inception:");
        movieList.updateRating("Inception", 9.1);
        movieList.displayForward();
        
        System.out.println("\nRemoving Pulp Fiction:");
        movieList.removeByTitle("Pulp Fiction");
        movieList.displayForward();
    }
} 