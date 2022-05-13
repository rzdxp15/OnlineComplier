class Trie {
    Node root;
    /** Initialize your data structure here. */
    class Node{
        boolean end;
        Node []next;
        public Node(){
            next=new Node[26];
        }
    }
    public Trie() {
        root=new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node=root;
        char[]c=word.toCharArray();
        for(char i:c){
            if(node.next[i-'a']==null){
                node.next[i-'a']=new Node();
            }
            node=node.next[i-'a'];
        }
        node.end=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node=root;
        for(char i:word.toCharArray()){
            if(node.next[i-'a']==null)return false;
            node=node.next[i-'a'];
        }
        return node.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node=root;
        for(char i:prefix.toCharArray()){
            if(node.next[i-'a']==null)return false;
            node=node.next[i-'a'];
        }
        return true;

    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */