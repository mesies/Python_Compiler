/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.lexer;

import java.io.*;
import java.util.*;
import minipython.node.*;

public class Lexer
{
    protected Token token;
    protected State state = State.INITIAL;

    private PushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    protected void filter() throws LexerException, IOException
    {
    }

    public Lexer(PushbackReader in)
    {
        this.in = in;

        if(gotoTable == null)
        {
            try
            {
                DataInputStream s = new DataInputStream(
                    new BufferedInputStream(
                    Lexer.class.getResourceAsStream("lexer.dat")));

                // read gotoTable
                int length = s.readInt();
                gotoTable = new int[length][][][];
                for(int i = 0; i < gotoTable.length; i++)
                {
                    length = s.readInt();
                    gotoTable[i] = new int[length][][];
                    for(int j = 0; j < gotoTable[i].length; j++)
                    {
                        length = s.readInt();
                        gotoTable[i][j] = new int[length][3];
                        for(int k = 0; k < gotoTable[i][j].length; k++)
                        {
                            for(int l = 0; l < 3; l++)
                            {
                                gotoTable[i][j][k][l] = s.readInt();
                            }
                        }
                    }
                }

                // read accept
                length = s.readInt();
                accept = new int[length][];
                for(int i = 0; i < accept.length; i++)
                {
                    length = s.readInt();
                    accept[i] = new int[length];
                    for(int j = 0; j < accept[i].length; j++)
                    {
                        accept[i][j] = s.readInt();
                    }
                }

                s.close();
            }
            catch(Exception e)
            {
                throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
            }
        }
    }

    public Token peek() throws LexerException, IOException
    {
        while(token == null)
        {
            token = getToken();
            filter();
        }

        return token;
    }

    public Token next() throws LexerException, IOException
    {
        while(token == null)
        {
            token = getToken();
            filter();
        }

        Token result = token;
        token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = pos;
        int start_line = line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        int[][][] gotoTable = this.gotoTable[state.id()];
        int[] accept = this.accept[state.id()];
        text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(cr)
                    {
                        cr = false;
                    }
                    else
                    {
                        line++;
                        pos = 0;
                    }
                    break;
                case 13:
                    line++;
                    pos = 0;
                    cr = true;
                    break;
                default:
                    pos++;
                    cr = false;
                    break;
                };

                text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        int middle = (low + high) / 2;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = text.length();
                    accept_pos = pos;
                    accept_line = line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            Token token = new0(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 1:
                        {
                            Token token = new1(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 2:
                        {
                            Token token = new2(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 3:
                        {
                            Token token = new3(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 4:
                        {
                            Token token = new4(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 5:
                        {
                            Token token = new5(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 6:
                        {
                            Token token = new6(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 7:
                        {
                            Token token = new7(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 8:
                        {
                            Token token = new8(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 9:
                        {
                            Token token = new9(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 10:
                        {
                            Token token = new10(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 11:
                        {
                            Token token = new11(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 12:
                        {
                            Token token = new12(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 13:
                        {
                            Token token = new13(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 14:
                        {
                            Token token = new14(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 15:
                        {
                            Token token = new15(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 16:
                        {
                            Token token = new16(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 17:
                        {
                            Token token = new17(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 18:
                        {
                            Token token = new18(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 19:
                        {
                            Token token = new19(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 20:
                        {
                            Token token = new20(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 21:
                        {
                            Token token = new21(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 22:
                        {
                            Token token = new22(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 23:
                        {
                            Token token = new23(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 24:
                        {
                            Token token = new24(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 25:
                        {
                            Token token = new25(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 26:
                        {
                            Token token = new26(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 27:
                        {
                            Token token = new27(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 28:
                        {
                            Token token = new28(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 29:
                        {
                            Token token = new29(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 30:
                        {
                            Token token = new30(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 31:
                        {
                            Token token = new31(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 32:
                        {
                            Token token = new32(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 33:
                        {
                            Token token = new33(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 34:
                        {
                            Token token = new34(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 35:
                        {
                            Token token = new35(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 36:
                        {
                            Token token = new36(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 37:
                        {
                            Token token = new37(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 38:
                        {
                            Token token = new38(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 39:
                        {
                            Token token = new39(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 40:
                        {
                            Token token = new40(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 41:
                        {
                            Token token = new41(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 42:
                        {
                            Token token = new42(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 43:
                        {
                            Token token = new43(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    }
                }
                else
                {
                    if(text.length() > 0)
                    {
                        throw new LexerException(
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + text);
                    }
                    else
                    {
                        EOF token = new EOF(
                            start_line + 1,
                            start_pos + 1);
                        return token;
                    }
                }
            }
        }
    }

    Token new0(String text, int line, int pos) { return new TTab(text, line, pos); }
    Token new1(int line, int pos) { return new TPlus(line, pos); }
    Token new2(String text, int line, int pos) { return new TPp(text, line, pos); }
    Token new3(int line, int pos) { return new TEqq(line, pos); }
    Token new4(int line, int pos) { return new TMinuseq(line, pos); }
    Token new5(int line, int pos) { return new TPluseq(line, pos); }
    Token new6(int line, int pos) { return new TDeq(line, pos); }
    Token new7(int line, int pos) { return new TIn(line, pos); }
    Token new8(int line, int pos) { return new TRange(line, pos); }
    Token new9(int line, int pos) { return new TNeqq(line, pos); }
    Token new10(int line, int pos) { return new TMinus(line, pos); }
    Token new11(int line, int pos) { return new TMult(line, pos); }
    Token new12(int line, int pos) { return new TDmult(line, pos); }
    Token new13(int line, int pos) { return new TDiv(line, pos); }
    Token new14(int line, int pos) { return new TEq(line, pos); }
    Token new15(int line, int pos) { return new TExclam(line, pos); }
    Token new16(int line, int pos) { return new TDictt(line, pos); }
    Token new17(int line, int pos) { return new TDef(line, pos); }
    Token new18(int line, int pos) { return new TLogicPlus(line, pos); }
    Token new19(int line, int pos) { return new TLPar(line, pos); }
    Token new20(int line, int pos) { return new TRPar(line, pos); }
    Token new21(int line, int pos) { return new TLBr(line, pos); }
    Token new22(int line, int pos) { return new TRBr(line, pos); }
    Token new23(int line, int pos) { return new TComma(line, pos); }
    Token new24(int line, int pos) { return new TQmark(line, pos); }
    Token new25(int line, int pos) { return new TGqmark(line, pos); }
    Token new26(int line, int pos) { return new TIf(line, pos); }
    Token new27(int line, int pos) { return new TElif(line, pos); }
    Token new28(int line, int pos) { return new TElse(line, pos); }
    Token new29(int line, int pos) { return new TWhile(line, pos); }
    Token new30(int line, int pos) { return new TPrint(line, pos); }
    Token new31(int line, int pos) { return new TReturn(line, pos); }
    Token new32(int line, int pos) { return new TFor(line, pos); }
    Token new33(int line, int pos) { return new TLess(line, pos); }
    Token new34(int line, int pos) { return new TGreat(line, pos); }
    Token new35(int line, int pos) { return new TTrue(line, pos); }
    Token new36(int line, int pos) { return new TSemi(line, pos); }
    Token new37(int line, int pos) { return new TFalse(line, pos); }
    Token new38(int line, int pos) { return new TQuote(line, pos); }
    Token new39(String text, int line, int pos) { return new TBlank(text, line, pos); }
    Token new40(String text, int line, int pos) { return new TLineComment(text, line, pos); }
    Token new41(String text, int line, int pos) { return new TNumber(text, line, pos); }
    Token new42(String text, int line, int pos) { return new TId(text, line, pos); }
    Token new43(String text, int line, int pos) { return new TString(text, line, pos); }

    private int getChar() throws IOException
    {
        if(eof)
        {
            return -1;
        }

        int result = in.read();

        if(result == -1)
        {
            eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            eof = false;

            in.unread(text.charAt(i));
        }
    }

    protected void unread(Token token) throws IOException
    {
        String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            eof = false;

            in.unread(text.charAt(i));
        }

        pos = token.getPos() - 1;
        line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INITIAL
            {{9, 9, 1}, {10, 10, 2}, {13, 13, 3}, {32, 32, 4}, {33, 33, 5}, {34, 34, 6}, {35, 35, 7}, {38, 38, 8}, {39, 39, 9}, {40, 40, 10}, {41, 41, 11}, {42, 42, 12}, {43, 43, 13}, {44, 44, 14}, {45, 45, 15}, {47, 47, 16}, {48, 57, 17}, {58, 58, 18}, {59, 59, 19}, {60, 60, 20}, {61, 61, 21}, {62, 62, 22}, {63, 63, 23}, {65, 90, 24}, {91, 91, 25}, {93, 93, 26}, {97, 99, 27}, {100, 100, 28}, {101, 101, 29}, {102, 102, 30}, {103, 104, 27}, {105, 105, 31}, {106, 111, 27}, {112, 112, 32}, {113, 113, 27}, {114, 114, 33}, {115, 115, 27}, {116, 116, 34}, {117, 118, 27}, {119, 119, 35}, {120, 122, 27}, },
            {},
            {},
            {{10, 10, 36}, },
            {},
            {{61, 61, 37}, },
            {{0, 9, 38}, {11, 12, 38}, {14, 33, 38}, {34, 34, 39}, {35, 127, 38}, },
            {{0, 9, 40}, {10, 10, 41}, {11, 12, 40}, {13, 13, 42}, {14, 127, 40}, },
            {{38, 38, 43}, },
            {{0, 9, 44}, {11, 12, 44}, {14, 38, 44}, {39, 39, 45}, {40, 127, 44}, },
            {},
            {},
            {{42, 42, 46}, },
            {{43, 43, 47}, {61, 61, 48}, },
            {},
            {{45, 45, 49}, {61, 61, 50}, },
            {{61, 61, 51}, },
            {{46, 46, 52}, {48, 57, 17}, },
            {},
            {},
            {},
            {{61, 61, 53}, },
            {},
            {},
            {{48, 57, 54}, {65, 90, 55}, {97, 122, 56}, },
            {},
            {},
            {{48, 122, -26}, },
            {{48, 90, -26}, {97, 100, 56}, {101, 101, 57}, {102, 104, 56}, {105, 105, 58}, {106, 122, 56}, },
            {{48, 90, -26}, {97, 107, 56}, {108, 108, 59}, {109, 122, 56}, },
            {{48, 90, -26}, {97, 97, 60}, {98, 110, 56}, {111, 111, 61}, {112, 122, 56}, },
            {{48, 90, -26}, {97, 101, 56}, {102, 102, 62}, {103, 109, 56}, {110, 110, 63}, {111, 122, 56}, },
            {{48, 90, -26}, {97, 113, 56}, {114, 114, 64}, {115, 122, 56}, },
            {{48, 90, -26}, {97, 97, 65}, {98, 100, 56}, {101, 101, 66}, {102, 122, 56}, },
            {{48, 113, -34}, {114, 114, 67}, {115, 122, 56}, },
            {{48, 90, -26}, {97, 103, 56}, {104, 104, 68}, {105, 122, 56}, },
            {},
            {},
            {{0, 127, -8}, },
            {{0, 127, -8}, },
            {{0, 127, -9}, },
            {},
            {{10, 10, 69}, },
            {},
            {{0, 127, -11}, },
            {{0, 127, -11}, },
            {},
            {},
            {},
            {},
            {},
            {},
            {{48, 57, 70}, },
            {},
            {{48, 122, -26}, },
            {{48, 122, -26}, },
            {{48, 122, -26}, },
            {{48, 101, -33}, {102, 102, 71}, {103, 122, 56}, },
            {{48, 90, -26}, {97, 98, 56}, {99, 99, 72}, {100, 122, 56}, },
            {{48, 90, -26}, {97, 104, 56}, {105, 105, 73}, {106, 114, 56}, {115, 115, 74}, {116, 122, 56}, },
            {{48, 107, -31}, {108, 108, 75}, {109, 122, 56}, },
            {{48, 113, -34}, {114, 114, 76}, {115, 122, 56}, },
            {{48, 122, -26}, },
            {{48, 122, -26}, },
            {{48, 104, -61}, {105, 105, 77}, {106, 122, 56}, },
            {{48, 90, -26}, {97, 109, 56}, {110, 110, 78}, {111, 122, 56}, },
            {{48, 90, -26}, {97, 115, 56}, {116, 116, 79}, {117, 122, 56}, },
            {{48, 90, -26}, {97, 116, 56}, {117, 117, 80}, {118, 122, 56}, },
            {{48, 104, -61}, {105, 105, 81}, {106, 122, 56}, },
            {},
            {{48, 57, 70}, },
            {{48, 122, -26}, },
            {{48, 115, -68}, {116, 116, 82}, {117, 122, 56}, },
            {{48, 101, -33}, {102, 102, 83}, {103, 122, 56}, },
            {{48, 100, -30}, {101, 101, 84}, {102, 122, 56}, },
            {{48, 90, -26}, {97, 114, 56}, {115, 115, 85}, {116, 122, 56}, },
            {{48, 122, -26}, },
            {{48, 109, -67}, {110, 110, 86}, {111, 122, 56}, },
            {{48, 90, -26}, {97, 102, 56}, {103, 103, 87}, {104, 122, 56}, },
            {{48, 116, -69}, {117, 117, 88}, {118, 122, 56}, },
            {{48, 100, -30}, {101, 101, 89}, {102, 122, 56}, },
            {{48, 107, -31}, {108, 108, 90}, {109, 122, 56}, },
            {{48, 122, -26}, },
            {{48, 122, -26}, },
            {{48, 122, -26}, },
            {{48, 100, -30}, {101, 101, 91}, {102, 122, 56}, },
            {{48, 115, -68}, {116, 116, 92}, {117, 122, 56}, },
            {{48, 100, -30}, {101, 101, 93}, {102, 122, 56}, },
            {{48, 113, -34}, {114, 114, 94}, {115, 122, 56}, },
            {{48, 122, -26}, },
            {{48, 100, -30}, {101, 101, 95}, {102, 122, 56}, },
            {{48, 122, -26}, },
            {{48, 122, -26}, },
            {{48, 122, -26}, },
            {{48, 109, -67}, {110, 110, 96}, {111, 122, 56}, },
            {{48, 122, -26}, },
            {{48, 122, -26}, },
        }
    };*/

    private static int[][] accept;
/*  {
        // INITIAL
        {-1, 0, 39, 39, 39, 15, 38, -1, -1, -1, 19, 20, 11, 1, 23, 10, 13, 41, 36, 25, 33, 14, 34, 24, 42, 21, 22, 42, 42, 42, 42, 42, 42, 42, 42, 42, 39, 9, -1, 43, -1, 40, 40, 18, -1, 43, 12, 2, 5, 2, 4, 6, -1, 3, 42, 42, 42, 42, 42, 42, 42, 42, 26, 7, 42, 42, 42, 42, 42, 40, 41, 17, 42, 42, 42, 42, 32, 42, 42, 42, 42, 42, 16, 27, 28, 42, 42, 42, 42, 35, 42, 37, 30, 8, 42, 29, 31, },

    };*/

    public static class State
    {
        public final static State INITIAL = new State(0);

        private int id;

        private State(int id)
        {
            this.id = id;
        }

        public int id()
        {
            return id;
        }
    }
}