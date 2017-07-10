import org.apache.commons.lang3.RandomStringUtils;

public class Library {
    // some comment
    public boolean someLibraryMethod() {
        RandomStringUtils.randomAlphabetic(10);
        return true;
    }

    public String someNotSoRandomString() {
        return RandomStringUtils.randomAlphabetic(3);
    }
}
