package final_lab;

import java.util.concurrent.TimeUnit;

public class lockTree {

    class lockNode {
        int act;
        lockNode p;
        int depth;

        public lockNode(int act, lockNode p) {
            this.act = act;
            this.p = p;
            if (p == null) {
                this.depth = 0;
            } else {
                this.depth = p.depth + 1;
            }
        }
    }

    //attributes
    lockNode root = new lockNode(-1, null);
    Queue<lockNode> queue = new Queue<lockNode>();
    Queue<lockNode> solution = new Queue<lockNode>();
    Stack<lockNode> stack = new Stack<lockNode>();
    long visited = 0;

    TheLock lock;

    //constructor
    public lockTree(TheLock lock) {
        this.lock = lock;
    }

    //print solution
    public void printSolution() {
        System.out.println();
        System.out.println("Length: " + solution.size);
        System.out.println("Number of visited lockNodes: " + visited);
        System.out.println("Stack memory occupied: " + stack.size);
        System.out.println("Queue memory occupied: " + queue.size);
        System.out.print("Solution: ");

        while (!solution.isEmpty()) {
            lockNode curr = solution.pop();
            if (curr.act == 1) {
                System.out.print("Twist  ");
            } else if (curr.act == 2) {
                System.out.print("Poke  ");
            } else if (curr.act == 3) {
                System.out.print("Pull  ");
            } else {
                System.out.print("Shake  ");
            }
        }
        System.out.println();
    }

    //if the solution is not right,add children
    public void addCtoQ(lockNode n) {
        lockNode c1 = new lockNode(1, n);
        lockNode c2 = new lockNode(2, n);
        lockNode c3 = new lockNode(3, n);
        lockNode c4 = new lockNode(4, n);
        queue.push(c1);
        queue.push(c2);
        queue.push(c3);
        queue.push(c4);
    }

    public void addCtoS(lockNode n) {
        lockNode c1 = new lockNode(1, n);
        lockNode c2 = new lockNode(2, n);
        lockNode c3 = new lockNode(3, n);
        lockNode c4 = new lockNode(4, n);
        stack.push(c4);
        stack.push(c3);
        stack.push(c2);
        stack.push(c1);
    }

    //act on the lock
    public boolean act(lockNode n) {

        if (n.act == 1) {
            lock.twistIt();
            solution.push(n);
            visited++;
            return lock.isUnlocked();
        } else if (n.act == 2) {
            lock.pokeIt();
            solution.push(n);
            visited++;
            return lock.isUnlocked();
        } else if (n.act == 3) {
            lock.pullIt();
            solution.push(n);
            visited++;
            return lock.isUnlocked();
        } else if (n.act == 4) {
            lock.shakeIt();
            solution.push(n);
            visited++;
            return lock.isUnlocked();
        } else {
            return lock.isUnlocked();
        }
    }

    // solve the lock by tracing back to root
    public boolean tryToSolve(lockNode n) {
        lock.resetLock();
        //act on the lock untill reach root
        while (n.act != -1) {
            boolean unlocked = act(n);
            if (unlocked) {
                printSolution();
                solution.clear();
                stack.clear();
                queue.clear();
                return true;
            }
            n = n.p;
        }

        solution.clear();
        return false;

    }

    public void BFS() {

        addCtoQ(root);
        lockNode curr = queue.pop();
        while (!lock.isUnlocked()) {

            boolean solved = tryToSolve(curr);
            if (solved) {
                return;
            }
            addCtoQ(curr);
            curr = queue.pop();

        }
    }


    public void DLS(int limit) {
        stack.push(root);
        int count = 0;
        // reach the bottom
        while (count < limit) {
            lockNode curr = stack.pop();
            addCtoS(curr);
            count++;
        }
        lockNode curr = stack.top();
        while (!stack.isEmpty()) {
            curr = stack.pop();
            //make sure the pop node is bottom node
            if (curr.depth == limit) {
                boolean solved = tryToSolve(curr);
                if (solved) {
                    return;
                }
            }
            // one branch is done, expand to another branch
            else if (curr.depth < limit) {
                addCtoS(curr);
            }
        }
        stack.clear();
    }


    public void IDS() {
        int limit = 1;
        while (!lock.isUnlocked()) {
            DLS(limit);
            if (lock.isUnlocked()) {
                return;
            }
            limit = limit + 1;
        }

    }


}
   
   
