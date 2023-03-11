## Java AWT 
- Java AWT (Abstract Window Toolkit) is an API to develop Graphical User Interface (GUI) or windows-based applications in Java.
- Java AWT components are platform-dependent i.e. components are displayed according to the view of operating system. 
- AWT is heavy weight i.e. its components are using the resources of underlying operating system (OS).
- The java.awt package provides classes for AWT API such as TextField, Label, TextArea, RadioButton, CheckBox, Choice, List etc.

**Why AWT is platform dependent?**
- Java AWT calls the native platform (operating systems) subroutine for creating API components like TextField, ChechBox, button, etc.
    - For example, an AWT GUI with components like TextField, label and button will have different look and feel for the different platforms like Windows, MAC OS, and Unix. 
    - The reason for this is the platforms have different view for their native components and AWT directly calls the native subroutine that creates those components.
- In simple words, an AWT application will look like a windows application in Windows OS whereas it will look like a Mac application in the MAC OS.

##### Java AWT Hierarchy

![N|Solid](https://i.imgur.com/87LKbeG.png)

**Components**
- All the elements like the button, text fields, scroll bars, etc. are called components. In Java AWT, there are classes for each component

**Container**
- The Container is a component in AWT that can contain another components like buttons, textfields, labels etc. The classes that extends Container class are known as container such as Frame, Dialog and Panel.
- It is basically a screen where the where the components are placed at their specific locations. Thus it contains and controls the layout of components.


**Types of containers:**
There are four types of containers in Java AWT:
- Window
    - Doesn't have no borders and menu bars. You must use frame, dialog or another window for creating a window. We need to create an instance of Window class to create this container. 
- Panel
    -  doesn't contain title bar, border or menu bar. It is generic container for holding the component
- Frame
    - Have title bar and border and can have menu bars. 
    - It can have other components like button, text field, scrollbar etc.
    - Frame is most widely used container while developing an AWT application.
- Dialog

**Methods**
- public void add(Component c)
- public void setSize(int width,int height)
- public void setLayout(LayoutManager m)
- public void setVisible(boolean status)

**To create simple AWT exampleclass, we need a frame. There are two ways to create a GUI using Frame in AWT.**

- By extending Frame class (inheritance)
- By creating the object of Frame class (association)

**Using Inheritance **
```java
import java.awt.*;    
public class AWTExample extends Frame {    
   AWTExample() {  
      Button b = new Button("Click Me!!");  
      b.setBounds(30,100,80,30);  
      add(b);  

      setSize(300,300); 
      setTitle("This is our basic AWT example");  
      setLayout(null);  
      setVisible(true);  
} 
public static void main(String args[]) {   
AWTExample f = new AWTExample();    
}  
}   
```

**AWT Example by Association**
```java
 
import java.awt.*;    
class AWTExample2 {    
   AWTExample2() {  
      Frame f = new Frame();  
      Label l = new Label("Employee id:");   
      Button b = new Button("Submit"); 
      TextField t = new TextField();  
      
      l.setBounds(20, 80, 80, 30);  
      t.setBounds(20, 100, 80, 30);  
      b.setBounds(100, 100, 80, 30);  
      
      f.add(b);  
      f.add(l);  
      f.add(t);  
     
      f.setSize(400,300);  
      f.setTitle("Employee info");   
      f.setLayout(null);
      f.setVisible(true);  
}    
  

public static void main(String args[]) {    
AWTExample2 awt_obj = new AWTExample2();    
    }  
}    
```


#### Event and Listener (Java Event Handling).

- Changing the state of an object is known as an event. 
- For example, click on button, dragging mouse etc. 
- The java.awt.event package provides many event classes and Listener interfaces for event handling.

![N|Solid](https://i.imgur.com/lVp6N1N.png)

**Steps to perform Event Handling**
- Register the component with the Listener

**Button** 
public void addActionListener(ActionListener a){}
**MenuItem**
public void addActionListener(ActionListener a){}
**TextField**
public void addActionListener(ActionListener a){}
public void addTextListener(TextListener a){}
**TextArea**
public void addTextListener(TextListener a){}
**Checkbox**
public void addItemListener(ItemListener a){}
**Choice**
public void addItemListener(ItemListener a){}
**List**
- public void addActionListener(ActionListener a){}
- public void addItemListener(ItemListener a){}

**Action Listener Example**
```java
import java.awt.*;  
import java.awt.event.*;  
class AEvent extends Frame implements ActionListener{  
TextField tf;  
AEvent(){  
    tf=new TextField();  
    tf.setBounds(60,50,170,20);  
    Button b=new Button("click me");  
    b.setBounds(100,120,80,30);  
      
    //register listener  
    b.addActionListener(this);//passing current instance  
 
    add(b);add(tf);  
    setSize(300,300);  
    setLayout(null);  
    setVisible(true);  
}  
public void actionPerformed(ActionEvent e){  
    tf.setText("Welcome");  
}  
    public static void main(String args[]){  
        new AEvent();  
    }  
} 
```

** Java event handling by anonymous class**
```java
import java.awt.*;  
import java.awt.event.*;  
class AEvent3 extends Frame{  
TextField tf;  
AEvent3(){  
    tf=new TextField();  
    tf.setBounds(60,50,170,20);  
    Button b=new Button("click me");  
    b.setBounds(50,120,80,30);  
      
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(){  
        tf.setText("hello");  
        }  
        });  
    add(b);add(tf);  
    setSize(300,300);  
    setLayout(null);  
    setVisible(true);  
}  
public static void main(String args[]){  
    new AEvent3();  
}  
}  
```

#### AWT Button
- A button is basically a control component with a label that generates an event when pushed. 
- The Button class is used to create a labeled button that has platform independent implementation. 
- The application result in some action when the button is pushed.

- To perform an action on a button being pressed and released, the ActionListener interface needs to be implemented. 
- The registered new listener can receive events from the button by calling addActionListener method of the button. 

**syntax**

```java
public class Button extends Component implements Accessible  
```

**Constructors**
- Button( ): It constructs a new button with an empty string i.e. it has no label.
- Button (String text) : It constructs a new button with given string as its label.

**Methods**
- void setText (String text)
- String getText()
- void setLabel (String label)
- String getLabel()
- void addActionListener(ActionListener l)
- void removeActionListener (ActionListener l)

**NOTE**: The Button class inherits methods from java.awt.Component and java.lang.Object classes.

```java
import java.awt.*;    
public class ButtonExample {    
public static void main (String[] args) {   
  
    // create instance of frame with the label   
    Frame f = new Frame("Button Example");    
  
    // create instance of button with label  
    Button b = new Button("Click Here");   
  
    // set the position for the button in frame   
    b.setBounds(50,100,80,30);    
  
    // add button to the frame  
    f.add(b);    
    // set size, layout and visibility of frame  
    f.setSize(400,400);    
    f.setLayout(null);    
    f.setVisible(true);     
}    
}  
```

**AWT Button Example with ActionListener**

```java
// importing necessary libraries  
import java.awt.*;    
import java.awt.event.*;    
public class ButtonExample3 {    
public static void main(String[] args) {    
    // create instance of frame with the label   
    Frame f = new Frame("Button Example");    
    final TextField tf=new TextField();    
    tf.setBounds(50,50, 150,20);  
    // create instance of button with label  
    Button b=new Button("Click Here");    
    // set the position for the button in frame   
    b.setBounds(50,100,60,30);   
    b.addActionListener(new ActionListener() {    
    public void actionPerformed (ActionEvent e) {    
            tf.setText("Welcome to Javatpoint.");    
        }    
    });  
// adding button the frame  
    f.add(b);  
// adding textfield the frame  
    f.add(tf);    
// setting size, layout and visibility   
    f.setSize(400,400);    
    f.setLayout(null);    
    f.setVisible(true);     
}    
}

```

