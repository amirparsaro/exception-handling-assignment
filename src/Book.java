public class Book {
    private String title;
    private int pageCount;

    public Book (String title, int pageCount) {
        // The next two ifs are in two blocks instead of "||", beacause if title was empty,
        // then we would have gotten this error: Cannot invoke "String.isEmpty()" because "title" is null.
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        else if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive.");
        }

        this.title = title;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return this.title + " (" + this.pageCount + " pages)";
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }
}
