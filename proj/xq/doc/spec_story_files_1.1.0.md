# The Specification for Contents of Story Files

当前版本：1.1.0

## 版本的变化规则

如果这份规范里，添加、更改或者删除了，对概念的描述或者例子；那么，版本号的最右边数字，就会加一。

如果这份规范里的已有的 EBNF 被更改或者删除，那么中间数字，就会加一。

如果这份规范里，添加了新的 EBNF，那么最左边的数字就会加一。


## 故事文件是什么

是保存在 story 文件夹下的所有的 txt 文件。

## 文件命名的规范

定义：Word。

<pre>
Digit = "0" .. "9"

Alpha = ("A" .. "Z") | ("a" .. "z")

AlphaDigit = Alpha | Digit

Word = AlphaDigit { AlphaDigit }
</pre>

定义：FileNameWithExtension。

<pre>
FileName = Word { "_" Word }

FileNameWithExtension = FileName ".txt"
</pre>

文件的名字，必须要符合 FileNameWithExtension。

## 文法的规范

定义：Uint。

<pre>
Uint = Digit { Digit }
</pre>

定义：Key。

<pre>
Key = Word { "." Word }
</pre>

### 文件内容的组成

定义：StoryFileContent。

<pre>
Nl = "\n"

Sp = " "

Line = ( StoryLine | Comment | Statment )

StoryFileContent = { {Sp} Line Nl }
</pre>

文件里面，所有行开始的空格，都会被忽略。

### 注释

定义：Comment。

<pre>
Rune = all_utf8_characters - "\n" - "\r"

String = "" | (Rune {Rune} )

Comment = "#" String
</pre>

因为解释器是逐行读的，所以 Rune 不能包括换行符。

AlphaDigit 是 Rune 的子集。Word 是 String 的子集。

### 讲故事的行

定义：StoryLine。

<pre>
StoryLine = PauseLine | FallThroughLine | OutdentLine
</pre>

定义：PauseLine。

<pre>
WhiteRune = " " | "\t"

NonWhiteRune = Rune - WhiteRune

PauseLine = NonWhiteRune { NonWhiteRune }
</pre>

定义：FallThroughLine。

<pre>
FallThroughLine = "" | ( "." String )
</pre>

定义：OutdentLine。

<pre>
OutdentLine = "<" { " " } String
</pre>

### 语句

定义：Statment。

<pre>
Statment = IfStmt | RedoStmt | RunStmt | PauseStmt | NewlineStmt | SetStmt
</pre>

定义：IfStmt。

<pre>
Key = "Input" | ( Word { "." Word } )

StoryFile = FileName | "_" | "$"

IfStmt = "@if" Key (StoryFile { StoryFile })
</pre>

定义：RedoStmt。

<pre>
RedoStmt = "@re"
</pre>

定义：RunStmt。

<pre>
UseStmt = "@run" StoryFile
</pre>

如果 StoryFile 是下划线（“_”），那解释器就什么都不做，然后直接跳过。

如果 StoryFile 是美元符号（“$”），那解释器就会停止执行这个文件。

如果 StoryFile 是自己的名字，那你就看着办吧。

定义：PauseStmt。

<pre>
PauseStmt = "@pause"
</pre>

定义：NewlineStmt。

<pre>
NewlineStmt = "@nl" Uint
</pre>

定义：SetStmt。

<pre>
SetStmt = "@set" Key Uint
</pre>

