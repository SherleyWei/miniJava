// Generated from MiniJava.g4 by ANTLR 4.7.2

	import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, MEMBER_OP=23, ASSIGN_OP=24, 
		SEMICOLON=25, SL_COMMENT=26, LEFT_BRACE=27, RIGHT_BRACE=28, LEFT_PARA=29, 
		RIGHT_PARA=30, RELATION_OP=31, LOGIC_OP=32, ADD_OP=33, MUL_OP=34, EXTENDS=35, 
		ID=36, INT=37, WS=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "MEMBER_OP", "ASSIGN_OP", 
			"SEMICOLON", "SL_COMMENT", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PARA", 
			"RIGHT_PARA", "RELATION_OP", "LOGIC_OP", "ADD_OP", "MUL_OP", "EXTENDS", 
			"ID", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'public'", "'protected'", "'private'", "'static'", "'class'", 
			"','", "'void'", "'int'", "'boolean'", "'['", "']'", "'return'", "'if'", 
			"'else'", "'while'", "'System.out.println'", "'length'", "'new'", "'!'", 
			"'true'", "'false'", "'this'", "'.'", null, "';'", null, "'{'", "'}'", 
			"'('", "')'", null, null, null, null, "'extends'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "MEMBER_OP", 
			"ASSIGN_OP", "SEMICOLON", "SL_COMMENT", "LEFT_BRACE", "RIGHT_BRACE", 
			"LEFT_PARA", "RIGHT_PARA", "RELATION_OP", "LOGIC_OP", "ADD_OP", "MUL_OP", 
			"EXTENDS", "ID", "INT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MiniJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u0125\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00dd\n\31"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u00e5\n\33\f\33\16\33\u00e8\13\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \5 \u00ff\n \3!\3!\3!\3!\5!\u0105\n!\3\"\3\"\3#\3#\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3%\3%\7%\u0115\n%\f%\16%\u0118\13%\3&\6&\u011b"+
		"\n&\r&\16&\u011c\3\'\6\'\u0120\n\'\r\'\16\'\u0121\3\'\3\'\3\u00e6\2(\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(\3\2\t\4\2>>@@\4\2--//\4\2,,\61\61\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2\u0131\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\3O\3\2\2\2\5V\3\2\2\2\7`\3\2\2\2\th\3\2\2\2\13o\3\2\2\2\ru\3"+
		"\2\2\2\17w\3\2\2\2\21|\3\2\2\2\23\u0080\3\2\2\2\25\u0088\3\2\2\2\27\u008a"+
		"\3\2\2\2\31\u008c\3\2\2\2\33\u0093\3\2\2\2\35\u0096\3\2\2\2\37\u009b\3"+
		"\2\2\2!\u00a1\3\2\2\2#\u00b4\3\2\2\2%\u00bb\3\2\2\2\'\u00bf\3\2\2\2)\u00c1"+
		"\3\2\2\2+\u00c6\3\2\2\2-\u00cc\3\2\2\2/\u00d1\3\2\2\2\61\u00dc\3\2\2\2"+
		"\63\u00de\3\2\2\2\65\u00e0\3\2\2\2\67\u00ed\3\2\2\29\u00ef\3\2\2\2;\u00f1"+
		"\3\2\2\2=\u00f3\3\2\2\2?\u00fe\3\2\2\2A\u0104\3\2\2\2C\u0106\3\2\2\2E"+
		"\u0108\3\2\2\2G\u010a\3\2\2\2I\u0112\3\2\2\2K\u011a\3\2\2\2M\u011f\3\2"+
		"\2\2OP\7r\2\2PQ\7w\2\2QR\7d\2\2RS\7n\2\2ST\7k\2\2TU\7e\2\2U\4\3\2\2\2"+
		"VW\7r\2\2WX\7t\2\2XY\7q\2\2YZ\7v\2\2Z[\7g\2\2[\\\7e\2\2\\]\7v\2\2]^\7"+
		"g\2\2^_\7f\2\2_\6\3\2\2\2`a\7r\2\2ab\7t\2\2bc\7k\2\2cd\7x\2\2de\7c\2\2"+
		"ef\7v\2\2fg\7g\2\2g\b\3\2\2\2hi\7u\2\2ij\7v\2\2jk\7c\2\2kl\7v\2\2lm\7"+
		"k\2\2mn\7e\2\2n\n\3\2\2\2op\7e\2\2pq\7n\2\2qr\7c\2\2rs\7u\2\2st\7u\2\2"+
		"t\f\3\2\2\2uv\7.\2\2v\16\3\2\2\2wx\7x\2\2xy\7q\2\2yz\7k\2\2z{\7f\2\2{"+
		"\20\3\2\2\2|}\7k\2\2}~\7p\2\2~\177\7v\2\2\177\22\3\2\2\2\u0080\u0081\7"+
		"d\2\2\u0081\u0082\7q\2\2\u0082\u0083\7q\2\2\u0083\u0084\7n\2\2\u0084\u0085"+
		"\7g\2\2\u0085\u0086\7c\2\2\u0086\u0087\7p\2\2\u0087\24\3\2\2\2\u0088\u0089"+
		"\7]\2\2\u0089\26\3\2\2\2\u008a\u008b\7_\2\2\u008b\30\3\2\2\2\u008c\u008d"+
		"\7t\2\2\u008d\u008e\7g\2\2\u008e\u008f\7v\2\2\u008f\u0090\7w\2\2\u0090"+
		"\u0091\7t\2\2\u0091\u0092\7p\2\2\u0092\32\3\2\2\2\u0093\u0094\7k\2\2\u0094"+
		"\u0095\7h\2\2\u0095\34\3\2\2\2\u0096\u0097\7g\2\2\u0097\u0098\7n\2\2\u0098"+
		"\u0099\7u\2\2\u0099\u009a\7g\2\2\u009a\36\3\2\2\2\u009b\u009c\7y\2\2\u009c"+
		"\u009d\7j\2\2\u009d\u009e\7k\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7g\2\2"+
		"\u00a0 \3\2\2\2\u00a1\u00a2\7U\2\2\u00a2\u00a3\7{\2\2\u00a3\u00a4\7u\2"+
		"\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7o\2\2\u00a7\u00a8"+
		"\7\60\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7w\2\2\u00aa\u00ab\7v\2\2\u00ab"+
		"\u00ac\7\60\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7k\2"+
		"\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3"+
		"\7p\2\2\u00b3\"\3\2\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7"+
		"\7p\2\2\u00b7\u00b8\7i\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7j\2\2\u00ba"+
		"$\3\2\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7y\2\2\u00be"+
		"&\3\2\2\2\u00bf\u00c0\7#\2\2\u00c0(\3\2\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3"+
		"\7t\2\2\u00c3\u00c4\7w\2\2\u00c4\u00c5\7g\2\2\u00c5*\3\2\2\2\u00c6\u00c7"+
		"\7h\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7u\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cb,\3\2\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7j\2\2\u00ce"+
		"\u00cf\7k\2\2\u00cf\u00d0\7u\2\2\u00d0.\3\2\2\2\u00d1\u00d2\7\60\2\2\u00d2"+
		"\60\3\2\2\2\u00d3\u00d4\7-\2\2\u00d4\u00dd\7?\2\2\u00d5\u00d6\7/\2\2\u00d6"+
		"\u00dd\7?\2\2\u00d7\u00d8\7,\2\2\u00d8\u00dd\7?\2\2\u00d9\u00da\7\61\2"+
		"\2\u00da\u00dd\7?\2\2\u00db\u00dd\7?\2\2\u00dc\u00d3\3\2\2\2\u00dc\u00d5"+
		"\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd"+
		"\62\3\2\2\2\u00de\u00df\7=\2\2\u00df\64\3\2\2\2\u00e0\u00e1\7\61\2\2\u00e1"+
		"\u00e2\7\61\2\2\u00e2\u00e6\3\2\2\2\u00e3\u00e5\13\2\2\2\u00e4\u00e3\3"+
		"\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7\f\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ec\b\33\2\2\u00ec\66\3\2\2\2\u00ed\u00ee\7}\2\2\u00ee8\3"+
		"\2\2\2\u00ef\u00f0\7\177\2\2\u00f0:\3\2\2\2\u00f1\u00f2\7*\2\2\u00f2<"+
		"\3\2\2\2\u00f3\u00f4\7+\2\2\u00f4>\3\2\2\2\u00f5\u00ff\t\2\2\2\u00f6\u00f7"+
		"\7>\2\2\u00f7\u00ff\7?\2\2\u00f8\u00f9\7@\2\2\u00f9\u00ff\7?\2\2\u00fa"+
		"\u00fb\7?\2\2\u00fb\u00ff\7?\2\2\u00fc\u00fd\7#\2\2\u00fd\u00ff\7?\2\2"+
		"\u00fe\u00f5\3\2\2\2\u00fe\u00f6\3\2\2\2\u00fe\u00f8\3\2\2\2\u00fe\u00fa"+
		"\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff@\3\2\2\2\u0100\u0101\7(\2\2\u0101\u0105"+
		"\7(\2\2\u0102\u0103\7~\2\2\u0103\u0105\7~\2\2\u0104\u0100\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0105B\3\2\2\2\u0106\u0107\t\3\2\2\u0107D\3\2\2\2\u0108"+
		"\u0109\t\4\2\2\u0109F\3\2\2\2\u010a\u010b\7g\2\2\u010b\u010c\7z\2\2\u010c"+
		"\u010d\7v\2\2\u010d\u010e\7g\2\2\u010e\u010f\7p\2\2\u010f\u0110\7f\2\2"+
		"\u0110\u0111\7u\2\2\u0111H\3\2\2\2\u0112\u0116\t\5\2\2\u0113\u0115\t\6"+
		"\2\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117J\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\t\7\2\2"+
		"\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011dL\3\2\2\2\u011e\u0120\t\b\2\2\u011f\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0124\b\'\2\2\u0124N\3\2\2\2\n\2\u00dc\u00e6\u00fe\u0104\u0116"+
		"\u011c\u0121\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}