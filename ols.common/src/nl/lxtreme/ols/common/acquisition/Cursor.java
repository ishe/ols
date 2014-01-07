/*
 * OpenBench LogicSniffer / SUMP project 
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110, USA
 *
 * Copyright (C) 2006-2010 Michael Poppitz, www.sump.org
 * Copyright (C) 2010-2012 J.W. Janssen, www.lxtreme.nl
 */
package nl.lxtreme.ols.common.acquisition;


import java.awt.*;


/**
 * Defines a cursor, which is a temporary marker in time defined somewhere on
 * the captured data.
 */
public interface Cursor extends Cloneable, Comparable<Cursor>
{
  // INNER TYPES

  /**
   * Denotes how to represent a cursor label. Used for automatic placement of
   * cursor labels.
   */
  public static enum LabelStyle
  {
    INDEX_ONLY, TIME_ONLY, LABEL_ONLY, INDEX_LABEL, LABEL_TIME;
  }

  // METHODS

  /**
   * Clears this cursor, making it undefined.
   */
  void clear();

  /**
   * Creates a clone of this cursor.
   * 
   * @return an exact copy of this cursor.
   */
  Cursor clone();

  /**
   * Returns the color of this cursor.
   * 
   * @return the color of this cursor, can be <code>null</code> in case the
   *         default (UI-specific) color should be used.
   */
  Color getColor();

  /**
   * Returns the index of this cursor.
   * 
   * @return an index, >= 0 && < 10.
   */
  int getIndex();

  /**
   * Returns the raw label of this cursor, as set with {@link #setLabel(String)}
   * .
   * 
   * @return the label, can be <code>null</code> if no label is (yet) defined.
   */
  String getLabel();

  /**
   * Returns a styled label for this cursor.
   * 
   * @param aStyle
   *          the label style to use, cannot be <code>null</code>.
   * @return a styled label, never <code>null</code>.
   */
  String getLabel( LabelStyle aStyle );

  /**
   * Returns the time stamp of this cursor.
   * 
   * @return a time stamp.
   * @throws IllegalStateException
   *           in case this cursor is undefined.
   * @see #isDefined()
   */
  long getTimestamp();

  /**
   * Returns whether or not this cursor has a label.
   * 
   * @return <code>true</code> if there's a label assigned to this cursor,
   *         <code>false</code> otherwise.
   */
  boolean hasLabel();

  /**
   * Returns whether the time stamp of this cursor falls within the range of a
   * given time stamp.
   * 
   * @param aTimestamp
   *          the time stamp to check against;
   * @param aDelta
   *          the delta deviation between this time stamp and the given time
   *          stamp, >= 0.
   * @return <code>true</code> if this cursor is within the area of the given
   *         time stamp, <code>false</code> otherwise.
   */
  boolean inArea( final long aTimestamp, final double aDelta );

  /**
   * Returns whether or not this cursor has a defined time stamp.
   * 
   * @return <code>true</code> if this cursor has a defined time stamp,
   *         <code>false</code> otherwise.
   */
  boolean isDefined();

  /**
   * Sets the color of this cursor.
   * 
   * @param aColor
   *          the color to set, can be <code>null</code> in case the default
   *          color for this cursor (UI-specific) should be used.
   */
  void setColor( final Color aColor );

  /**
   * Sets the label.
   * 
   * @param aLabel
   *          the label to set
   */
  void setLabel( final String aLabel );

  /**
   * Sets the time stamp for this cursor.
   * 
   * @param aTimestamp
   *          the time stamp to set, >= 0.
   */
  void setTimestamp( final long aTimestamp );

}
