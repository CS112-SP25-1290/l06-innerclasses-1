public class Person implements Comparable<Person> {
    // CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Jamie Doe";
    public static final Identity DEFAULT_IDENTITY = new Identity("Unknown", "Unknown");
    public static final int DEFAULT_PRIVILEGE = 100;

    // INSTANCE VARIABLES
    private String name;
    private Identity identity;
    private int privilege;

    // INNER CLASS Identity
    public static class Identity {
        private String pronouns;
        private String background;

        public Identity(String pronouns, String background) {
            this.pronouns = pronouns;
            this.background = background;
        }

        public String getPronouns() {
            return pronouns;
        }

        public void setPronouns(String pronouns) {
            this.pronouns = pronouns;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        @Override
        public String toString() {
            return "Pronouns: " + pronouns + ", Background: " + background;
        }
    }

    // CONSTRUCTORS
    public Person(String name, Identity identity, int privilege) {
        this.setAll(name, identity, privilege);
    }

    public Person() {
        this(DEFAULT_NAME, DEFAULT_IDENTITY, DEFAULT_PRIVILEGE);
    }

    public Person(Person original) {
        if (original == null) {
            throw new IllegalArgumentException("Cannot copy null object in Person copy constructor");
        } else {
            this.setAll(original.name, new Identity(original.identity.pronouns, original.identity.background), original.privilege);
        }
    }

    // MUTATORS/SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public void setAll(String name, Identity identity, int privilege) {
        this.setName(name);
        this.setIdentity(identity);
        this.setPrivilege(privilege);
    }

    // ACCESSORS / GETTERS
    public String getName() {
        return this.name;
    }

    public Identity getIdentity() {
        return this.identity;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    // INTERFACE METHOD - Implementing Comparable
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.privilege, other.privilege);
    }

    // OTHER REQUIRED METHODS
    @Override
    public String toString() {
        return "My name is " + this.name + " and " + this.identity.toString() + "\n" +
                "According to this calculator, I ended up with " + this.privilege + " estimated privilege points";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return this.name.equals(otherPerson.name) &&
                this.identity.pronouns.equals(otherPerson.identity.pronouns) &&
                this.identity.background.equals(otherPerson.identity.background) &&
                this.privilege == otherPerson.privilege;
    }
}
