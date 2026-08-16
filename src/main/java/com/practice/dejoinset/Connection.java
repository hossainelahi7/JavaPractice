package com.practice.dejoinset;
import java.util.*;


public class Connection {


        public static class Node {
            int parent = -1;
            int num = 1;
            public static int findRoot(Node [] tree, int i) {
                // assume it's the root, or fix it
                int root = i;
                while (tree[root].parent != -1) {
                    root = tree[root].parent;
                }

                // flat the tree
                if (root != i) {
                    tree[i].parent = root;
                    // further optimize
                    // int j = i;
                    // while (j != root) {
                    //     int p = tree[j].parent;
                    //     tree[i].parent = root;
                    //     j = p;
                    // }
                }

                return root;
            }
        }

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int q = sc.nextInt();
            if (n < 1 || q < 1) {
                sc.close();
                return;
            }

            // Tree solution
            Node [] tree = new Node[n+1];
            for (int i = 1; i < tree.length; i++) {
                tree[i] = new Node();
            }
            while (q-- > 0) {
                String c = sc.next();
                if (c.equals("M")) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int ra = Node.findRoot(tree, a);
                    int rb = Node.findRoot(tree, b);
                    if (ra != rb) {
                        tree[ra].parent = rb;
                        tree[rb].num += tree[ra].num;
                    }
                }
                else if (c.equals("Q")) {
                    int i = sc.nextInt();
                    int ri = Node.findRoot(tree, i);
                    System.out.println(tree[ri].num);
                }
            }
            sc.close();
        }
    }

