// A C program to match wild card characters
#include <stdio.h>
#include <stdbool.h>
 
// The main function that checks if two given strings match. The first
// string may contain wildcard characters
bool match(const char *s, const char *p) {  
  // Start typing your C/C++ solution below  
  // DO NOT write int main() function  
  bool star = false;  
  const char *str, *ptr;  
  for(str = s, ptr =p; *str!='\0'; str++, ptr++)  
  {  
    switch(*ptr)  
    {  
       case '?':  
         break;  
       case '*':  
         star =true;  
         s=str, p =ptr;  
         while(*p=='*')  
           p++;  
         if(*p == '\0') // 如果'*'之后，pat是空的，直接返回true  
           return true;  
         str = s-1;  
         ptr = p-1;  
         break;  
       default:  
       {  
         if(*str != *ptr)  
         {  
           // 如果前面没有'*'，则匹配不成功  
           if(!star)  
             return false;  
           s++;  
           str = s-1;  
           ptr = p-1;  
         }  
       }  
     }  
   }  
   while(*ptr== '*')  
     ptr++;  
   return (*ptr == '\0');  
 }  
 
// A function to run test cases
void test(char *first, char *second)
{  match(second, first)? puts("Yes"): puts("No"); }
 
// Driver program to test above functions
int main()
{
    test("g*ks", "geeks"); // Yes
    test("ge?ks*", "geeksforgeeks"); // Yes
    test("g*k", "gee");  // No because 'k' is not in second
    test("*pqrs", "pqrst"); // No because 't' is not in first
    test("abc*bcd", "abcdhghgbcd"); // Yes
    test("abc*c?d", "abcd"); // No because second must have 2 instances of 'c'
    test("*c*d", "abcd"); // Yes
    test("*?c*d", "abcd"); // Yes
    test("**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb", "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb");
    return 0;
}
