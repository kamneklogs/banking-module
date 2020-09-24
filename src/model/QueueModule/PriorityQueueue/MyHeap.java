package model.QueueModule.PriorityQueueue;

import java.util.ArrayList;

import model.User;

public class MyHeap {

    public ArrayList<User> elements;

    public MyHeap() {
        elements = new ArrayList<User>();
    }

    private void goUp() {
        int k = elements.size() - 1;

        while (k > 0) {
            int p = (k - 1) / 2;
            User element = elements.get(k);
            User parent = elements.get(p);

            if (element.getSpecialCondition() > parent.getSpecialCondition()) {

                // swap
                elements.set(k, parent);
                elements.set(p, element);

                k = p;

            } else {
                break;
            }
        }
    }

    public int compTo(User a, User b) {
        if (a.getSpecialCondition() < b.getSpecialCondition()) {
            return -1;
        } else if (a.getSpecialCondition() > b.getSpecialCondition()) {
            return 1;
        }

        return 0;
    }

    public void insert(User element) {
        elements.add(element);
        goUp();
    }

    private void goDown() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < elements.size()) {
            int max = l, r = l + 1;
            // compTo(element.get(r), element)
            if (r < elements.size()) { // hay un hijo derecho
                if (elements.get(r).getSpecialCondition() > elements.get(l).getSpecialCondition()) {
                    // cambiar
                    User temp = elements.get(k);
                    elements.set(k, elements.get(max));
                    elements.set(max, temp);
                    k = max;
                    l = 2 * k + 1;
                }
            } else {
                break;
            }
        }
    }

    public User deleteElement() {
        if (elements.size() == 0) {

        }
        if (elements.size() == 1) {
            return elements.remove(0);
        }
        User hold = elements.get(0);
        elements.set(0, elements.remove(elements.size() - 1));
        goDown();
        return hold;
    }

}
