class WordDictionary {

    WordDictionary[] children;
    boolean isEndWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEndWord = false;
    }

    public void addWord(String word) {
        WordDictionary curr = this;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new WordDictionary();
            }
            curr = curr.children[index];
        }
        curr.isEndWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this);
    }

    private boolean dfs(String word, int index, WordDictionary node) {

        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                for (WordDictionary child : node.children) {
                    if (child == null) continue;
                    if (dfs(word, i+1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.children[ch-'a'] == null) {
                    return false;
                }
                node = node.children[ch-'a'];
            }
        }
    
        return node.isEndWord;
    }
}
