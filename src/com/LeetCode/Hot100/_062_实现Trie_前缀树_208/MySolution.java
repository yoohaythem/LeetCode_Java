package com.LeetCode.Hot100._062_实现Trie_前缀树_208;

//20221110
class MySolution {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }

}


class Trie {

    Trie[] children;
    boolean end;

    public Trie() {
        children = new Trie[26];
        end = false;
    }

    public void insert(String word) {
        if (word.length() == 0) {
            end = true;
            return;
        }
        int index = word.charAt(0) - 'a';
        if (children[index] == null) {
            children[index] = new Trie();
        }
        children[index].insert(word.substring(1));   // substring 拖慢了速度，应改为 for 循环加 node = node.children[index]
    }

    public boolean search(String word) {
        if (word.length() == 0) {
            return end;
        }
        int index = word.charAt(0) - 'a';
        if (children[index] == null) {
            return false;
        }
        return children[index].search(word.substring(1));
    }

    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }
        int index = prefix.charAt(0) - 'a';
        if (children[index] == null) {
            return false;
        }
        return children[index].startsWith(prefix.substring(1));
    }
}
