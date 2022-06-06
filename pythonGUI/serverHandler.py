from asyncio import subprocess
from asyncore import write
from tkinter import messagebox
from webbrowser import get
from py4j.java_gateway import JavaGateway
import shutil
"""
Importing TkInter
TkInter    is   a   binding   lib   from   tlc/tk.
It  is  an  standard  for developing python GUI's.
It is installed on windows.
"""
from distutils import text_file
from logging import root
from tkinter import *
from collections import deque
from tkinter import filedialog
import os
import tkinter.font as tkFont
from pathlib import Path

"""
Main class that will enable us to generate a window.
"""
class TheMainWindow:
    def hi(self):
        print("YESYESYES")
    """
    Method for creating new file
    This file will open file dialog to create a file
    and save it on desired directory with .ml extension.
    Any other code on the IDE will get deleted.
    Must create cpp with same name as file.
    Must also copy bat compiling file.
    Must create bat file for running.
    """
    def file_new(self):
        self.text_one.delete("1.0", END)
        root.title("New File")
        self.current_open_file_path = ""
    """
    Method for opening ml files
    Will open a file dialog to open desired file.
    Should also delete current code on IDE.
    Must check if cpp and bat file are on directory:
        if not create add files
    """
    def file_open(self):
        # Deleteing prev txt on IDE
        self.text_one.delete("1.0", END)
        # File dialog -> grabs file name and location
        location = filedialog.askopenfilename(initialdir="./", title="Open File", filetypes=(("MLang Files", "*.ml"),))
        if location:
            self.current_open_file_path = location
        root.title(os.path.split(location)[1])
        text_file = open(location, 'r')
        the_txt = text_file.read()
        self.text_one.insert(END, the_txt)
        text_file.close()
        self.updater()
    """
    Method for saving as
    """
    def file_save_as(self):
        # self.file_new()
        # Change this line 60 for setting the default directory
        # mlang_file = filedialog.asksaveasfilename(defaultextension=".ml",
        #                                         initialdir="C:/Users/Gar-m/Desktop/javaMLang/running_examples",
        #                                         title="Save File",
        #                                         filetypes=  (("MLang Files", "*.ml"),))
        mlang_file = filedialog.asksaveasfilename(defaultextension=".ml",
                                                initialdir= self.dir + "/running_examples",
                                                title="Save File",
                                                filetypes=  (("MLang Files", "*.ml"),))
        # if filename exists
        if mlang_file:
            self.current_open_file_path = mlang_file
            name = os.path.split(mlang_file)[1]
            # path
            p = os.path.split(mlang_file)[0]
            root.title(name)
            # Save file
            mlang_file = open(mlang_file, 'w')
            mlang_file.write(self.text_one.get(1.0, END))
            # Close the file
            mlang_file.close()

    """
    Method for saving file changes
    This will save all the current code on
    corresponding file.
    Must check if cpp and bat file are on directory:
        if not create add files
    """
    def file_save(self):
        if self.current_open_file_path:
            mlang_file = open(self.current_open_file_path, 'w')
            mlang_file.write(self.text_one.get(1.0, END))
            mlang_file.close()
        else:
            self.file_save_as()
    """
    Method for making the translation and show it on right panel.
    Will make and save changes to cpp
    Must check if cpp and file are on directory:
        if not creat add files
    """
    def make_translation(self):
        txt_input = self.text_one.get("1.0", "end")             # Getting the whole txt on GUI
        self.tokens_print_space.config(state = "normal")
        self.tokens_print_space.delete("1.0", END)
        translation = ""
        try:
            translation = self.java_server_handler.getTranslation(txt_input)
        except Exception as msg:
            messagebox.showerror("erro", msg)
        self.tokens_print_space.insert(END, translation)
        self.tokens_print_space.config(state = "disabled")
    """
    Method for Running the translation.
    Must check if cppp and bat file on directory:
        if not cancel
    """
    def run_translation(self):
        self.file_save()
        self.make_translation()
        p = os.path.split(self.current_open_file_path)[0] + '/'
        name = os.path.split(self.current_open_file_path)[1].split(".")[0]+'.cpp'
        cpp_file = open(p + name, 'w')
        print(p+name)
        self.tokens_print_space.config(state = "normal")
        cpp_file.write(self.tokens_print_space.get(1.0, END))
        self.tokens_print_space.config(state = "disabled")
        cpp_file.close()
        # shutil.copyfile("C:/Users/Gar-m/Desktop/javaMLang/pythonGUI/matrixLib/Matrix.h", p+"Matrix.h")
        shutil.copyfile(self.dir + '/pythonGUI/matrixLib/Matrix.h', p+"Matrix.h")
        print(self.dir + '/pythonGUI/matrixLib/Matrix.h')
        os.system("start g++ "+ p+name + " -o example")
        os.system("example")

    
    """
    Method for running the java server
    This one will set the necessary commands on command promt
    for runnign the .jar file.
    https://stackoverflow.com/questions/9333637/how-to-execute-java-program-using-python-considering-inputs-and-outputs-both
    """
    def run_server(self):
        pass
    """
    The TheMainWindow class constructor
    """
    def __init__(self, t_root):

        """
        CHANGE THIS FOR SETTING YOUR CURRENT WORKING DIRECTORY.
        PLEASE SET THE LOCATION OF THE REPO
        """
        self.dir = "C:/Users/Gar-m/Desktop/javaMLang"
        """
        PY4J server run
        iniating server connection
        """
        self.gateway = JavaGateway()                   # connect to the JVM
        random = self.gateway.jvm.java.util.Random()   # create a java.util.Random instance
        number1 = random.nextInt(10)              # call the Random.nextInt method
        number2 = random.nextInt(10)
        print(number1, number2)
        self.java_server_handler = self.gateway.entry_point               # get the AdditionApplication instance
        value = self.java_server_handler.addition(number1, number2) # call the addition method
        print(value)
        self.bold_font = tkFont.Font(weight='bold')
        """
        Setting tkinter constructor
        """
        self.root = t_root                                  # Here we input the TKinter root constructor
        self.root.option_add("*Font", "Verdana 12")         # Declaring font 

        root.title("MLangIDE")
        """
        Creating Main window frame
        """
        self.main_window = Frame(self.root)                 # Input Tkinter main constructor into Frame
        """
        Attribute for storing current file path
        """
        self.current_open_file_path = ""
        """
        Creating menu bar
        """
        self.menu_bar =  Menu(self.root)
        self.filemenu = Menu(self.menu_bar, tearoff=0)
        self.filemenu.add_command(label="New", command=self.file_new)
        self.filemenu.add_command(label="Open", command=self.file_open)
        self.filemenu.add_command(label="Save", command=self.file_save)
        self.filemenu.add_command(label="Save as", command=self.file_save_as)
        self.filemenu.add_command(label="Translate", command=self.make_translation)
        self.filemenu.add_command(label="Run", command=self.run_translation)
        self.filemenu.add_separator()
        self.root.config(menu=self.filemenu)
        """
        Attributes used by stackify method
        """
        self.stack = deque(maxlen = 0)
        self.stackcursor = 0
        """
        Window/Frame label
        """
        self.label_one = Label(self.main_window, text= "MLangIDE")  # set label/title to window
        self.label_one.pack(padx = 5, pady = 5)
        """
        Creating txt input frame 
        """
        self.text_one = Text(self.main_window, width=45, height=35)            # creating text input box
        self.text_one.pack(padx=5, pady=5, side=LEFT)
        """
        Creating txt output frame
        """
        self.tokens_print_space = Text(self.main_window, width=45, height=35)
        self.tokens_print_space.pack(padx=5, pady=5, side=RIGHT) 
        self.tokens_print_space.config(state = "disabled")
        self.main_window.pack(padx = 5, pady = 5)


    """
    create highlight
    """
    def generate_tag(self, t_token_kind, t_line, t_character_start, t_length, t_color):
        tag_name = t_token_kind + str(t_line) + str(t_length)
        coordinate_start    = str(t_line) + "." + str(t_character_start)
        coordinate_end      = str(t_line) + "." + str(int(t_character_start) + t_length)
        # tag_name, coordinate_start, coordinate_end
        if t_color == 'green':
            self.text_one.tag_configure(tag_name, font=self.bold_font)
            self.text_one.tag_add(tag_name, coordinate_start, coordinate_end)
        else:
            self.text_one.tag_add(tag_name, coordinate_start, coordinate_end)
        # tag_name, foreground  = t_color
        self.text_one.tag_config(tag_name, foreground=t_color)
    
    """
    Highlighter Method
    """
    def highlighter(self):
        start   = "1.0"
        end     = "end"
        """
        Get the whole txt from the IDE
        """
        txt_input = self.text_one.get("1.0", "end")             # Getting the whole txt on GUI
        getTks = self.java_server_handler.getTokens(txt_input) 

        theType = {
            0   :   "main",
            1   :   "matrix",
            2   :   "int",
            3   :   "write",
            4   :   "num"
        }
        theColor = {
            0   :   "green",
            1   :   "green",
            2   :   "green",
            3   :   "green",
            4   :   "blue"
        }

        """
        Create Tags
        """
        if len(getTks) > 0:
            for i in range(0, len(getTks), 4):
                self.generate_tag(theType[getTks[i+2]],
                                  getTks[i],
                                  getTks[i+1],
                                  getTks[i+3],
                                  theColor[getTks[i+2]]
                )



    """
    Update
    """
    def updater(self):
        self.stackify()
        self.highlighter()
    
    """
    Clear
    """
    def clear(self):
        self.text_one.delete("1.0", "end")

        self.tokens_print_space.config(state="normal")
        self.tokens_print_space.delete("1.0", "end")
        self.tokens_print_space.config(state="disabled")


    
    """
    stackify
    """
    def stackify(self):
        self.stack.append(self.text_one.get("1.0", "end - 1c"))
        if self.stackcursor < 9:
            self.stackcursor += 1
    

"""
TK_IDE run
"""
root = Tk()
the_window = TheMainWindow(root)
root.bind("<Key>", lambda event: the_window.updater())
root.mainloop()


