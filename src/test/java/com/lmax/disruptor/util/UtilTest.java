/*
 * Copyright 2011 LMAX Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lmax.disruptor.util;

import com.lmax.disruptor.Sequence;

import org.junit.Assert;
import org.junit.Test;

public final class UtilTest
{
    private static final long HIGHER_VALUE = 12L;
    private static final long MIDDLE_VALUE = 7L;
    private static final long LOWER_VALUE = 3L;
    private static final int VALUE_GRATER_THAN_512_AND_LESS_THAN_1023 = 1000;

    @Test
    public void shouldReturnNextPowerOfTwo()
    {
        int powerOfTwo = Util.ceilingNextPowerOfTwo(VALUE_GRATER_THAN_512_AND_LESS_THAN_1023);

        Assert.assertEquals(1024, powerOfTwo);
    }

    @Test
    public void shouldReturnExactPowerOfTwo()
    {
        int powerOfTwo = Util.ceilingNextPowerOfTwo(1024);

        Assert.assertEquals(1024, powerOfTwo);
    }

    @Test
    public void shouldReturnMinimumSequence()
    {
        final Sequence[] sequences = {new Sequence(MIDDLE_VALUE), new Sequence(LOWER_VALUE), new Sequence(HIGHER_VALUE)};
        Assert.assertEquals(LOWER_VALUE, Util.getMinimumSequence(sequences));
    }

    @Test
    public void shouldReturnLongMaxWhenNoEventProcessors()
    {
        final Sequence[] sequences = new Sequence[0];

        Assert.assertEquals(Long.MAX_VALUE, Util.getMinimumSequence(sequences));
    }
}
