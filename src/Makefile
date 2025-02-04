# Define the Java compiler
JAVAC = javac

# Define the source files
SRCS = Main.java Helper.java

# Define the class files
CLASSES = Iperfer.class 

# Define the target to compile all Java files
all: $(CLASSES)

# Rule for compiling Java files
%.class: %.java
	$(JAVAC) $<

# Rule for running the main Java file
compile: all

# Rule to clean up the generated class files
clean:
	rm -f $(CLASSES)