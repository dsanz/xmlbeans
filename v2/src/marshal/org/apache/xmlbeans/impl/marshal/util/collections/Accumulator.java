/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.xmlbeans.impl.marshal.util.collections;


public interface Accumulator
{

    int DEFAULT_INITIAL_CAPACITY = 16;

    void append(Object elem);

    /**
     * append default value for this type
     * (null of Objects, normal java defaults for primtive types)
     */
    void appendDefault();

    void set(int index, Object value);

    int size();

    /**
     * This method must be idempotent between calls to add or set.
     *
     * @return
     */
    Object getFinalArray();

}
