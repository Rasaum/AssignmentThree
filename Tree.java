import java.util.Queue;

public class Tree <Key extends Comparable<Key>, Values> {

    private Node root;

    private class Node{
        private String key;
        private Product product;
        private Node left, right;

        public Node (String key, Product product)
        {
            this.key=key;
            this.product=product;
        }
    }

    public void put (String key, Product product){
        root = put(root, key, product);
    }

    private Node put(Node x, String key, Product product){
        if (x==null) return new Node(key, product);
        int cmp = key.compareTo(x.key);
        if (cmp<0)
            x.left = put(x.left, key, product);
        else if (cmp>0)
            x.right = put(x.right, key, product);
        else if (cmp == 0)
            x.product =product;
        return x;
    }

    public Product get(String key){
        Node  x=root;
        while (x != null){
            int cmp= key.compareTo(x.key);
            if (cmp < 0) x=x.left;
            else if (cmp > 0) x=x.right;
            else return x.product;
        }
        return null;
    }


}

