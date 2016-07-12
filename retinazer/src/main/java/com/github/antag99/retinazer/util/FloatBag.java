/*******************************************************************************
 * Copyright (C) 2015 Anton Gustafsson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.github.antag99.retinazer.util;

public final class FloatBag {
    @Experimental
    public float[] buffer;

    public FloatBag() {
        this(0);
    }

    public FloatBag(int capacity) {
        buffer = new float[capacity];
    }

    public void ensureCapacity(int capacity) {
        if (this.buffer.length >= capacity)
            return;
        int newCapacity = Bag.nextPowerOfTwo(capacity);
        float[] newBuffer = new float[newCapacity];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
        this.buffer = newBuffer;
    }

    public float get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0: " + index);
        }

        if (index >= buffer.length) {
            return 0;
        }

        return buffer[index];
    }

    public void set(int index, float value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0: " + index);
        }

        if (index >= buffer.length) {
            ensureCapacity(index + 1);
        }

        buffer[index] = value;
    }

    public void clear() {
        float[] buffer = this.buffer;
        for (int i = 0, n = buffer.length; i < n; ++i) {
            buffer[i] = 0;
        }
    }

    public void clear(Mask mask) {
        float[] buffer = this.buffer;
        for (int i = mask.nextSetBit(0), n = buffer.length; i != -1 && i < n; i++) {
            buffer[i] = 0;
        }
    }
}
