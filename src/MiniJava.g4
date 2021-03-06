grammar MiniJava;
@header{
	import java.util.*;
}

@parser::members{
	public enum Scope{MEMBER,FUNC};   //scope
	
	public static boolean isArrayType(String a)	{
		return (a!= null && a.indexOf("[]") != -1);
	}
	
	public static void checkArrayType(String a,Token op)	{
		if(!isArrayType(a)) {
			System.out.println("type mismatched :need an array name at line " +
				op.getLine() +":" + op.getCharPositionInLine()
			);
		}
	}
	
	public static boolean isRequireType(String a,String type){
		return (a!=null && a.equals(type));
	}
	
	public static void checkType(String a,Token op,String type){
		if (!(isRequireType(a,type))){
			System.out.println("type mismatched :need " + type+ " at line " +
				op.getLine() +":" + op.getCharPositionInLine()
			);
		}
	}


	//Check if the type of two operands meets the requirements	
	public static void checkType(String a,String b, Token op,String type)
	{
		if (a== null || !(a.equals(type))){
			System.out.println("type mismatched in arg1 of expression at line " +
				op.getLine() +":" + op.getCharPositionInLine()
			);
		}
		if (b == null || !(b.equals(type))){
			System.out.println("type mismatched in arg2 of expression at line " +
				op.getLine() +":" + op.getCharPositionInLine()
			);
		}
	}
	
	//Check if the variable is the same as the keyword
	public static boolean isKeyWord(String id)
	{
		List<String> keys = new ArrayList<String>();
		keys.add("int");
		keys.add("boolean");
		keys.add("void");
		keys.add("if");
		keys.add("while");
		keys.add("else");
		keys.add("public");
		keys.add("protected");
		keys.add("default");
		keys.add("private");
		keys.add("extends");
		keys.add("class");
		keys.add("return");
		keys.add("true");
		keys.add("false");
		keys.add("this");
		keys.add("super");
		return keys.contains(id);
	}
	
	//Find a class object and return NULL if it doesn't exist
	public static Class_declContext findClass(ProgContext prog, String class_name){
		Class_declContext v =null;
		List<Class_declContext> class_list = prog.class_list;
		for(Class_declContext e:class_list)	{
			if (e.name.equals(class_name)){
				v = e;
				break;				
			}			 
		}
		return v;
	}

	public static boolean isClassExists(ProgContext prog, String class_name){
		return findClass(prog, class_name) != null;	
	}
	
	//Find a variable name in the member list of the class
	public static Var_declContext findVar(Class_declContext classdecl, String var_name){
		Var_declContext v =null;
		List<Var_declContext> var_list = classdecl.var_list;
		for(Var_declContext e:var_list)	{
			if (e.name.equals(var_name)){
				v = e;
				break;				
			}			 
		}
		return v;
	}
	
	public static boolean isVarExists(Class_declContext obj, String class_name){
		return findVar(obj, class_name) != null;	
	}

	

	// find a variable name from the scope of an expression.
	public static Var_declContext findVar(ExprContext expr, String var_name){
		Var_declContext v =null;
		ParserRuleContext parent = expr.getParent();
		while (!(parent instanceof Method_declContext)){
			parent = parent.getParent();
		}
		
		Method_declContext func = (Method_declContext)parent;
		v = findVar(func,var_name);
		if (v==null){
			v = findPara(func,var_name);
		}
		if (v==null){
			Class_declContext c=(Class_declContext)(func.getParent());
			v = findVar(c,var_name);
		}
		return v;
	}
	
		
	//Find a variable name in the function's variable list
	public static Var_declContext findVar(Method_declContext func, String var_name){
		Var_declContext v =null;
		List<Var_declContext> var_list = func.var_list;
		for(Var_declContext e:var_list)	{
			if (e.name.equals(var_name)){
				v = e;
				break;				
			}			 
		}
		return v;
	}
	
	public static boolean isVarExists(Method_declContext func, String var_name){
		return findVar(func,var_name) != null; 
	}
	
	//Find a variable name in the function's argument list
	public static Var_declContext findPara(Method_declContext func, String para_name){
		Var_declContext v =null;
		List<Para_declContext> para_list = func.para_list;
		for(Para_declContext e: para_list) {
				ParaDeclContext t = (ParaDeclContext)e;
				Var_declContext s = t.var;
				if (s.name.equals(para_name)) {
					v = s;
					break;
				}
		}			
		return v;
	}
	//check if a parameter already exists
	public static boolean isParaExists(Method_declContext func, String para_name){
		return findPara(func,para_name) != null; 
	}
	
	// check if two function declarations are exactly the same
	public static boolean isEqual(Method_declContext fun1,Method_declContext fun2) 
	{
		boolean flag = (fun1.name.equals(fun2.name) && fun1.para_list.size()==fun2.para_list.size());
		if(flag){
			for(int i=0;i<fun1.para_list.size();++i)
			{
				ParaDeclContext t1 = (ParaDeclContext)(fun1.para_list.get(i));
				ParaDeclContext t2 = (ParaDeclContext)(fun2.para_list.get(i));
				
				String type1 = t1.var.type;
				String type2 = t2.var.type;
				if (!(type1.equals(type2)))
				{
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	//check if the same function is already in the class
	public static boolean isFuncExists(Class_declContext obj,Method_declContext fun) 
	{
		boolean flag = false;
		for(Method_declContext e:obj.func_list)
		{
			if (isEqual(e,fun))
			{
				flag =true;
				break;
			}
		}
		return flag;
	}
}

	


prog      :   (class_list += class_decl)+;

//define class_decl
class_decl
locals[
	String name    
] : 
     // include class_head_name
    class_head_name 
    '{'
	  ( ('public'|'protected'|'private')? 
	  	('static' var_list  += var_decl[true,MiniJavaParser.Scope.MEMBER])
	  	|
	  	(var_list  += var_decl[false,MiniJavaParser.Scope.MEMBER])
	  	SEMICOLON
	  )*
	   (func_list += method_decl)*
	'}'
    ;

//define class_head_name and the error detection
class_head_name:
	'class' class_name = ID ( EXTENDS parent_name = ID ) ?
	{
		//notified if the class is exited
		Class_declContext parent =(Class_declContext) ($ctx.getParent());
		parent.name = $class_name.text;
		
		ProgContext prog =(ProgContext) (parent.getParent());
		
		if (MiniJavaParser.isClassExists(prog,parent.name))
			System.out.println("class name: " + parent.name + " is refined " + "at line " 
					+ $class_name.line + ":" + $class_name.pos
				);
		else
			System.out.println("add new class name:" + parent.name + " to class name list");	
	}
	; 

//define var declaration and the error detection code
var_decl[boolean static_flag,MiniJavaParser.Scope var_scope]
locals
[
	String type;
	String name;
	boolean is_static = false; 
	MiniJavaParser.Scope scope 
]
	:var_type ID 
	{
		String var_name = $ID.text;
		$ctx.type = $var_type.text;
		$ctx.name = $ID.text;
		$ctx.scope = $var_scope;
		$ctx.is_static = $static_flag;
		
		ParserRuleContext parent = $ctx.getParent();
                                if (parent instanceof Class_declContext) {  //Var belongs to a class
			Class_declContext c =(Class_declContext)(parent);
			Var_declContext var = MiniJavaParser.findVar(c,var_name);
			
			if (var != null && var.is_static == $static_flag){
				System.out.println("var " + $ID.text + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
					);
			}
			else {
				System.out.println("add new member var: " + $ctx.name + 
					" in class " + c.name + " successful"
				);
			}
		}

		else if (parent instanceof Para_declContext)
		{ 
			//If the var is a function parameter,find the parent node
			while (!(parent instanceof Method_declContext) ){
				parent = parent.getParent();
			}
						
			Method_declContext c =(Method_declContext)parent;
			
			if (MiniJavaParser.isParaExists(c,var_name))
			{
				System.out.println("para " + $ID.text+" in function" + c.name + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
					);
			}
			else {
				System.out.println("add new par: " + $ctx.name +" in function " + c.name + " successful");
			}	
		}

		else if (parent instanceof Method_declContext){  
			//if the var is a local variable in a funciton
			Method_declContext c = (Method_declContext)parent;
			
			if (MiniJavaParser.isVarExists(c,var_name))
			{
				System.out.println("var " + $ID.text +" in function" + c.name + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
				);
			}
			else if (MiniJavaParser.isParaExists(c,var_name))
			{
				System.out.println("var " + $ID.text +" in function " + c.name 
				 + " has same name with some para " + "at line "+ $ID.line + ":" + $ID.pos);
			}
			else 
			{
				System.out.println("add new var: " + $ctx.name 
					+" in function " + c.name + " successful"
				);
			} 
		}
	}
	;

method_decl
locals[
	String name;     //fuciton name
	String type;  //return type
	boolean is_static 
]
:
	//define method
	('public'|'protected'|'private')? (b='static')? 
	func_head_name LEFT_PARA (para_list += para_decl (',' para_list += para_decl)*)? RIGHT_PARA
	'{'
	 (
	 	('static' var_list += var_decl[true,MiniJavaParser.Scope.FUNC] SEMICOLON)
	 	|
	 	(var_list += var_decl[false,MiniJavaParser.Scope.FUNC] SEMICOLON) 
	 )*
	 (stat_list += stat)*
	'}'

	{
		$ctx.is_static = ($b.text!=null);
		//Check if the function can be overloaded
		Class_declContext parent =(Class_declContext) ($ctx.getParent());
		if (MiniJavaParser.isFuncExists(parent,$ctx))
		{
			System.out.println("overload function:" + $ctx.name + " in class "+ parent.name + "failed"
			+ " at line " + $LEFT_PARA.line + ":" + $LEFT_PARA.pos	
			);
		}
		else {
			System.out.println("add function:" + $ctx.name + " to class " + parent.name + " success");		
		}
	} 
	;
	
func_head_name:
	func_type ID
	{
		//Record function name and return type name
		Method_declContext c =(Method_declContext)($ctx.getParent()); 
		c.name = $ID.text;
		c.type = $func_type.text;
	}
	;	

para_decl:
	var=var_decl[false,MiniJavaParser.Scope.FUNC]
	#ParaDecl
	;

func_type:
	'void'|var_type
	;


var_type:
	array_type
	|basic_type
	;


basic_type:
	'int'
	|'boolean'
	|ID
	;
	
array_type:
	basic_type ('['']')+ 
	;	

class_body_start:LEFT_BRACE
	;
	
class_body_end:RIGHT_BRACE
	;

stat:
	'{' (stat)* '}'
	|'return' (expr)? ';'
	|	'if' '(' expr ')' stat 'else' stat
	|	'while' '(' expr ')' stat
	|	'System.out.println' '(' expr ')' ';'
	|	ID (array_index)? ASSIGN_OP expr ';'
	{
		//Check the stat, the ID on the left must exist, and the name of the expression on the right is the same
	}
	;		


expr_list:
	expr(',' expr)*
	;

expr returns [String type]:      //type记录表达式的类型名
	'(' a=expr ')'
	{
		$type = $a.type;
	}
	|	a = expr  op='[' b= expr ']'
	{
		MiniJavaParser.checkArrayType($a.type,$op);
		MiniJavaParser.checkType($b.type,$op,"int");
		if (MiniJavaParser.isArrayType($a.type)){
			int L =$a.type.length();
			$type = $a.type.substring(0,L-2);
		}
	}
	|	a=expr op=MEMBER_OP 'length'
	{
		MiniJavaParser.checkArrayType($a.type,$op);
		$type = "int";
	}
	|   a=expr op=MEMBER_OP ID '(' (expr_list)? ')'{
		
	}
	|	'new' basic_type array_index   //Multidimensional array definition
	{
		$type = $basic_type.text+$array_index.text;
	}  
	|	'new' basic_type '(' ')'              //Univariate
	{
		$type = $basic_type.text;
	}
	|	'!' a=expr
	{
		$type = "boolean";
	}
	| 	a=expr op=MUL_OP  b=expr
	{
		MiniJavaParser.checkType($a.type,$b.type,$op,"int");
		$type = "int";
	}
	| 	a=expr op=ADD_OP b=expr
	{
		MiniJavaParser.checkType($a.type,$b.type,$op,"int");
		$type = "int";
	}
	| 	a=expr op=RELATION_OP b=expr
	{
		MiniJavaParser.checkType($a.type,$b.type,$op,"int");
		$type = "boolean";
	}
	| 	a=expr op=LOGIC_OP b=expr
	{
		MiniJavaParser.checkType($a.type,$b.type,$op,"boolean");
		$type = "boolean";
	}
	|  INT
	{
		$type = "int";
	}
	|  ID
	{
		String var_name = $ID.text;
		if(MiniJavaParser.isKeyWord(var_name))   //Check if using keywords as ID
		{
			System.out.println("error: keword: " +var_name + " is used as an ID "+ " at " +$ID.line + ":"+$ID.pos);
		}
		
		Var_declContext v = MiniJavaParser.findVar($ctx,var_name);
		if (v!=null)
			$type = v.type;
	}
	|  'true'
	{
		$type = "boolean";
	}
	|  'false'
	{
		$type = "boolean";
	}
	|  'this'
	{
		//check if the "this" object is the class name of the current class
		ParserRuleContext parent=$ctx.getParent();
		while(!(parent instanceof Class_declContext)) {
			parent=parent.getParent();
		}
		Class_declContext c=(Class_declContext)parent;
		$type = c.name;
	}
	;


array_index:
	('[' expr ']')+
	;

MEMBER_OP:
	'.'
	;
ASSIGN_OP:
	 '+='|'-='|'*='|'/='|'='
	;

SEMICOLON
	: ';'
	;
	
SL_COMMENT
    : '//' .*?  '\n' -> skip  //Filter line comments
    ;
    

LEFT_BRACE:'{';    
RIGHT_BRACE:'}';

LEFT_PARA:'(';    
RIGHT_PARA:')';

RELATION_OP:
	'<'|'>'|'<='|'>='|'=='|'!='
	;
	
LOGIC_OP:
	'&&'|'||';

ADD_OP :'+'|'-'
	;

MUL_OP	:'*'|'/'
	;

EXTENDS:
	'extends'
	;
	
ID  :   [a-zA-Z_][a-zA-Z_0-9]* ;    

INT :   [0-9]+ ;        

WS  :   [ \r\n\t]+ -> skip ; 			