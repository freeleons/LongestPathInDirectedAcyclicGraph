PROGRAMMING EXERCISE
Directed acyclic graphs (DAGs) are a class of graph in computer science. Directed meaning the structure goes one way (there are from and to vertices, conceptually); acyclic meaning there are no loops (if A leads to B, B cannot lead to A).
DAGs are a collection of vertices and edges, which could be represented as simple objects (these classes are just to illustrate, you can use them or define your own):
class Vertex {
long id
}
class Edge {
Vertex from
Vertex to
}
Given a DAG and a vertex, calculate the longest directed path from that vertex. To give the exercise some reference, this was an actual problem encountered in the IPaC program  - showing progress through a variable-length, graph-based questionnaire.
QUESTIONS
1.	Does the solution work for larger graphs?
Please refer to the Word docx file for the answer.
3. Can you think of any optimizations?
Please refer to the Word docx file for the answer.
3.	What’s the computational complexity of your solution?
Please refer to the Word docx file for the answer.
5. Are there any unusual cases that aren't handled?
Please refer to the Word docx file for the answer.