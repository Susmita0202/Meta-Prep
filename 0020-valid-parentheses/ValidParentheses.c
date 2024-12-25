bool isValid(char* s) {
    int n= strlen(s);
    char* stack= (char*)malloc(n * sizeof(s));
    int t=-1;
    for(int i=0; s[i]; i++){
        char ch= s[i];

        if(ch == '(' || ch == '{' || ch == '['){
            stack[++t] = ch;
        }else{
            if(t==-1) return false;
            char open = stack[t--];
            if((ch == ')' && open != '(') ||
            (ch == '}' && open != '{') ||
            (ch == ']' && open != '[')){
                return false;
            }
            
        }
    }
    return t == -1;
}
