package unit10.httpserver;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

/**
 * A simple stream for reading HTTP messages. 
 */
public class HttpStream implements Closeable {

    private final BufferedReader br;

    public HttpStream(InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
    }

    /**
     * Provides access to the lines in a HTTP message.
     * @return a stream of lines in the HTTP message, ending at the first blank line.
     */
    public Stream<String> lines() {
        return br.lines()
                .takeWhile(line -> !line.isEmpty())
                .onClose(() -> {
                // IMPORTANT: do NOT close br (would close socket).
                });
    }

    /**
     * Closes the stream. Note that this does NOT close the underlying socket, 
     * so the caller is responsible for closing the socket when done.
     */
    @Override public void close() throws IOException {
        br.close();
    }

    /**
     * Reads a line of text from the stream.
     * @return Line of text that was read from the stream
     * @throws UncheckedIOException if an I/O error occurs while reading from the stream
     */
    public String readLine () {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Reads up to n characters from the stream and returns them as a string.
     * Useful for when the exact size of the content is known or there is
     * no terminating newline character.
     * @param n Number of characters to try and read from the stream. 
     *          If the end of the stream is reached before n characters are read, 
     *          then the method will return a string containing all characters read 
     *          up to that point.
     * @return A string containing the characters read from the stream.
     * @throws UncheckedIOException if an I/O error occurs while reading from the stream
     */
    public String readChars(int n) {
        char[] buffer = new char[n];
        try {
            int read = br.read(buffer);
            if (read == -1) {
                return null;
            }   
            return new String(buffer, 0, read);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
