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
package com.github.antag99.retinazer;

public final class EntityRemoveEvent implements Event {
    Entity entity;
    Class<? extends Component>[] with;
    Class<? extends Component>[] exclude;

    EntityRemoveEvent() {
    }

    /**
     * @return The entity that was removed.
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * @return The required components of the family this entity was removed from.
     *         Modifying the returned array leads to undefined behavior.
     */
    public Class<? extends Component>[] with() {
        return with;
    }

    /**
     * @return The excluded components of the family this entity was removed from.
     *         Modifying the returned array leads to undefined behavior.
     */
    public Class<? extends Component>[] exclude() {
        return exclude;
    }
}