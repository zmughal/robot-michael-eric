all:	$(wildcard *.java) tags
	javac *.java
clean:
	-rm -rf *.class
	-rm -rf tags

tags:	$(wildcard *.java)
	-ctags *.java

.PHONY:	all
