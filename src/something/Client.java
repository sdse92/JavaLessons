package something;

    public class Client {
    private String name;
    private String surname;
    private String busket [];

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void add(){}
    public void remove(){}

        @Override
        public String toString() {
            return "Client{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }
