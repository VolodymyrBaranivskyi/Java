# Code Style and Conventions 
| [English](README.md) | [Русский](README.ru.md) |

<<<<<<< HEAD
### Use snake_case when naming symbols, methods, and variables. But its not Java language
```Ruby
#badly
: 'Some symbol'
: SomeSymbol
: SomeSymbol

SomeVar = 5
Var_10 = 10

Def someMethod
 #Some code
End

Def SomeMethod
 #Some code
End

#OK

: Some_symbol

Some_var = 5
Var10 = 10.

Def some_method
   #Some code
End
```

### Do not separate numbers and letters in names of symbols, methods, and variables. 

```Ruby
#badly
: Some_sym_1

Some_var_1 = 1

Def some_method_1
   #Some code
End

OK
: Some_sym1

Some_var1 = 1

Def some_method1
   #Some code
End
```

### Use CamelCase for class names and modules. Abbreviations like HTTP, RFC, XML should be typed in capital letters. 

```Ruby
#badly
Class Someclass
   #Some code
End

Class Some_Class
   #Some code
End

Class SomeXml
   #Some code
End

Class XmlSomething
   #Some code
End

#OK
Class SomeClass
  #Some code
End

Class SomeXML
   #Some code
End

Class XMLSomething
   #Some code
End
```

### Use SCREAMING_SNAKE_CASE for all other constants except class names and modules. 

```Ruby
#badly
SomeConst = 5

#OK
SOME_CONST = 5
```

### Identifiers of predicative methods, i.e. Methods that return a logical value must end with a question mark. For example, Array # empty ?. Methods that do not return a Boolean value must not end with a question mark. 

### Do not use redundant names of predicate methods such as is_, does_ or can_. Such prefixes do not correspond to the conventions accepted in the standard Ruby library (#empty? Or #include ?, for example). 

```Ruby
#badly
Class Person
  Def is_tall?
    True
  End

  Def can_play_basketball?
    False
  End

  Def does_like_candy?
    True
  End
End

#OK
Class Person
  Def tall?
    True
  End

  Def basketball_player?
    False
  End

  Def likes_candy?
    True
  End
End
```

### Identifiers of potentially dangerous methods, i.e. Such methods that can change self or its arguments must end with an exclamation mark if there is an appropriate safe version of such a method. For example, exit !, which does not call the final script, in contrast to the exit that is finalizing. 

```Ruby
#Bad (there is no corresponding safe analog)
Class Person
  Def update!
  End
End

#OK
Class Person
  Def update
  End
End

#OK
Class Person
  Def update!
  End

  Def update
  End
End
```

### Define a safe method (option without an exclamation point) by calling a dangerous method (with an exclamation point), if possible. 

```Ruby
Class Array
  Def flatten_once!
    Res = []

    Each do | e |
      [* E] .each {| f | Res << f}
    End

    Replace (res)
  End

  Def flatten_once
    Dup.flatten_once!
  End
End
```

### When defining binary operators, call the parameter other. The only exception is the methods # << and # [], since their semantics are very different. 

```Ruby
Def + (other)
   #Some code
End
```

### Avoid single-line methods. And although they are quite popular among programmers, there are a lot of unpleasant little things connected with the syntax of their definition, which make application of such methods undesirable.

```Ruby
#badly
Def too_much; Something; Something_else; End

Def no_braces_method; Body end

 
Def no_braces_method; Body; End

Def some_method () body end

#OK
Def some_method
  Body
End
```

### One exception in this rule are methods with an empty body.

```Ruby
#OK
Def no_op; End
```

### Use empty lines to separate method definitions and highlight the logical parts of the definitions inside them.

```Ruby
Def some_method
  Data = initialize (options)

  Data.manipulate!

  Data.result
End

Def some_method
  Result
End
```

### Use a single style of multi-line sequential method call chains. In the Ruby community, two mutually exclusive styles of design are popular: with a point at the beginning (variant A) and with a point at the end (variant B). 

### A When you continue the chain of method calls to the next line, start from the point.

```Ruby
#Bad (you need to look at the previous line to understand

One.two.three.
  The four

#Well (it's immediately clear what happens in the second line)
One.two.three
  .four
```

### B Accordingly, on the contrary, when continuing the chain of calls on the next line, end the line with a dot, making it clear that the continuation of the expression follows

```Ruby
#Bad (you need to look at the previous line to understand
One.two.three.
  The four

#Well (it's immediately clear what happens in the second line)
One.two.three
  .four
```

### B Accordingly, on the contrary, when continuing the chain of calls on the next line, end the line with a dot, making it clear that the continuation of the expression follows

```Ruby
#Bad (to understand that the expression is not completed, it is necessary
One.two.three
  .four

#Good (you can immediately see that the expression will continue on
One.two.three.
  The four
```

### Use def with brackets when the method has parameters. Drop parentheses when the method does not accept parameters. 

```Ruby
#badly
Def some_method ()
   #Some code
End

#OK
Def some_method
   #Some code
End

#badly
Def some_method_with_parameters param1, param2
   #Some code
End

#OK
Def some_method_with_parameters (param1, param2)
   #Some code
End
```

### Use parentheses around arguments when calling a method, especially if the first argument starts with a character ((like this: f ((3 + 2) + 1)) 

```Ruby
#badly
X = Math.sin y
#OK
X = Math.sin (y)

#badly
Array.delete e
#OK
Array.delete (e)

#badly
Temperance = Person.new 'Temperance', 30
#OK
Temperance = Person.new ('Temperance', 30)
```

### When the method is called with no arguments:

```Ruby
#badly
Kernel.exit! ()
2.even? ()
Fork ()
'Test'.upcase ()

#OK
Kernel.exit!
2.even?
Fork
'Test'.upcase
```

### When methods are part of an internal DSL (ie Rake, Rails, RSpec):

```Ruby
 #badly
Validates (: name, presence: true)
#OK
Validates: name, presence: true
```

### When methods have keyword statuses in Ruby:

```Ruby
Class Person
   #badly
  Attr_reader (: name,: age)
  #OK
  Attr_reader: name,: age

   #Some code
End

#badly
Puts (temperance.age)
#OK
Puts temperance.age
```

### Define optional arguments at the end of the argument list. The way Ruby handles optional arguments when calling the method may seem ambiguous if they are set at the top of the list. 

```Ruby
#badly
Def some_method (a = 1, b = 2, c, d)
  Puts "# {a}, # {b}, # {c}, # {d}"
End

Some_method ('w', 'x') # => '1, 2, w, x'
Some_method ('w', 'x', 'y') # => 'w, 2, x, y'
Some_method ('w', 'x', 'y', 'z') # => 'w, x, y, z'

#OK
Def some_method (c, d, a = 1, b = 2)
  Puts "# {a}, # {b}, # {c}, # {d}"
End

Some_method ('w', 'x') # => '1, 2, w, x'
Some_method ('w', 'x', 'y') # => 'y, 2, w, x'
Some_method ('w', 'x', 'y', 'z') # => 'y, z, w, x'
```

### Use the for statement only in cases where you know exactly why you are doing this. In the vast majority of other cases it is worthwhile to use iterators.

```Ruby
Arr = [1, 2, 3]

#badly
For elem in arr do
  Puts elem
End

Elem # => 3

#OK
Arr.each {| elem | Puts elem}

Elem # => NameError: undefined local variable or method `elem '
```

### Do not use then for conditions if / unless declared on several lines. 

```Ruby
#badly
If some_condition then
   #Some action
End

#OK
If some_condition
   #Some action
End
```

### Always write a condition for if / unless on the same line that contains if / then in a multi-line condition. 

```Ruby
#badly
If
  X> 1
   #Some actions
End

#OK
If x> 1
   #Some actions
End
```

### Prefer the ternary operator (? :) constructs with if / then / else / end. It is used more often and by definition is more concise. 

```Ruby
#badly
Result = if some_condition then something else something_else end

#OK
Result = some_condition? Something: something_else
```

### Use only one expression in each branch of the ternary operator. It follows that it is better to avoid nested ternary operators. If this happens, use the constructs with if / else. 

```Ruby
#badly
Some_condition? (Nested_condition? Nested_something: nested_something_else): something_else

#OK
If some_condition
  Nested_condition? Nested_something: nested_something_else
Else
  #Something_else
End
```

### Use the || = operator to initialize variables only if the variable is not initialized yet. 

```Ruby
#badly
Name = name? Name: 'Bozhidar'

#badly
Name = 'Bozhidar' unless name

#Good (assign `name` to 'Boz' only if its
Name || = 'Bozhidar'
```

### Do not use the || = operator to initialize the boolean variables. This will cause problems if the current value of the variable is false.

```Ruby
#Bad (assigns the enabled variable true, even if it was false)
Enabled || = true

#OK
Enabled = true if enabled.nil?
```

### Use the && = operator to pre-work with variables that are already or have not been initialized. Using the && = operator changes the value of a variable only if it is initialized. This eliminates the need for checking with if. 

```Ruby
#badly
If something
  Something = something.downcase
End

#badly
Something = something? Something.downcase: nil

#Passable
Something = something.downcase something like that

#OK
Something = something && something.downcase

#better
Something && = something.downcase
```

### Avoid using the equality operator explicitly in case ===. As his name suggests, this statement is intended for implicit use in case expressions, in isolation from them, it only leads to different 
interpretations in the code. 

```Ruby
#badly
Array == = something
(1..100) === 7
/ Something / === some_string

#OK
Something.is_a? (Array)
(1..100) .include? (7)
Some_string = ~ / something /
```

### Do not use eql? If enough ==. A more stringent comparison semantics implemented in eql ?, is rarely needed in practice. 

```Ruby
#Bad (`eql?` Works for strings, like `==`)
'Ruby'.eql? Some_str

#OK
'Ruby' == some_str
```
