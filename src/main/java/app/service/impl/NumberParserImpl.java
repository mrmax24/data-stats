package app.service.impl;

import app.service.NumberParser;

public class NumberParserImpl implements NumberParser {
    @Override
    public Integer parse(String line) {
        return Integer.parseInt(line.trim());
    }
}
