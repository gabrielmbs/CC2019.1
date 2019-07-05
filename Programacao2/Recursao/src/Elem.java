public class Elem {
    private Elem prox;
    private String v;
    private int index = 0;


    public Elem(String v) {
        this.v = v;
    }

    public void add(String v) {
        if (this.prox == null) {
            this.prox = new Elem(v);
        } else {
            this.prox.add(v);
        }

    }

    public int size() {
        if (this.prox == null) {
            return 1;
        }

        return 1 + this.prox.size();
    }

    public boolean contains(String v) {
        if (this.v.equals(v)) {
            return true;
        }

        if (this.prox == null) {
            return false;
        }

        return this.prox.contains(v);
    }

    public int indexOf(String v) {
        if (this.prox == null) {
            return -1;
        }
        if (this.v.equals(v)) {
            return this.index;
        }
        return this.prox.indexOf(v, this.index + 1);
    }

    private int indexOf(String v, int i) {
        if (this.prox == null || this.v.equals(v)) {
            return i;
        }
        return this.prox.indexOf(v, i + 1);
    }

    public String get(int index) {
        if (this.index == index) {
            return this.v;
        }
        if (this.index > index || this.prox == null) {
            return null;
        }
        return this.prox.get(index, this.index + 1);
    }

    private String get(int index, int i) {
        if (i == index) {
            return this.v;
        }
        if (i > index || this.prox == null) {
            return null;
        }
        return this.prox.get(index, i + 1);
    }

    public void remove(int index) {
        this.remove(index, 0);
    }

    private void remove(int index, int i) {
        if(index == 0){
            String v = this.v;
            this.v = this.prox.v;
            this.prox.v = v;
            index = 1;
        }
        if (index - 1 == i) {
            this.prox = this.prox.prox;
            return;
        }
        this.prox.remove(index, i + 1);
    }

    @Override
    public String toString() {
        if(this.prox == null) return this.v;
        return this.v + " " + this.prox.toString();
    }
}
