# Set interface implementation programming challenge

## Welcome

Dear Candidate - first of all thank you for participating and accepting the challenge. We appreciate your efforts and hope to soon meet you in person.

## General rules

There are not many rules, the few are there to provide a light framework and to help us assess your workflow and mindset.
Please observe the following:

- We ask you to fork this project and create a pull request when you are done
- Please be honest to us and to yourself and do not spend more than 8 hours of work on this project including research and development
- You are free to structure the project as you like
- Commit small, commit often

## Allowed tooling

- The solution will need to be implemented in the Java language (7 or later)
- Please don't use any libraries apart from the ones used for testing
- Please don't use anything from java.util package (including ArrayList, HashMap etc)
- You can choose your build/project management system - we recommend you use Maven, if you use anything else please provide build instructions in a separate text file

## The task at hand

The task is to implement the interfaces: Set and SetIterator.
We do realise that there are plenty of working implementations for sets and they are well defined in Java, but we do not intend to verify that you can Google a solution. The point of this exercise is to assess your skills.

We ask you to implement a solution either using native java arrays or by object nesting. The Set and SetIterator interfaces are generic but they will only need to work for java number types (Integer, Long, Float etc) and Strings.

### The rules that define the workings of a set

- A set is a collection of unique elements of the same type
- Two sets are equal if they both contain the same elements regardless of their order (we look for content equality ie.: 1 == 1, "aaa".equals("aaa"))
- The union of two sets is a set that contains all elements from both sets
- The intersection of two sets is a set of elements that are contained in both sets

# Additional information and tips

- There are no tricks to this exercise
- We are aware that java arrays don't play very well with generics therefore you can always use Object[] arrays and cast them when needed ie.: D[] arr = (D[]) new Object[0];
- We appreciate the effort you'll put into this project, and we are happy if your solution scales, but we won't test your solution with more than 10000 elements
- Don't overcomplicate your solution, the implementation of the methods is not required to run in constant time
- The methods defined in the Set interface are in order of importance, try to tackle them from top to bottom, it's not a tragedy if you don't finish all of them
- If you are brave you can try a more functional Java 8 solution
- If you have questions regarding the project or something is not clear you can let me know at marton dot tatai at kpn dot com

# Disclaimer

This programming challenge is one step in a multiple step hiring process. It is a means to assess the competency of our candidates.
The work you will do - including writing code and/or designing software - is NOT going to be reused, copied or in any form replicated by us or any of our third parties.
If you have any concerns - related to what is stated above or the programming challenge itself - please email me at marton dot tatai at kpn dot com.

