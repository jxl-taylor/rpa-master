/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.menu;

import com.alee.api.annotations.NotNull;
import com.alee.api.annotations.Nullable;
import com.alee.managers.style.StyleManager;
import com.alee.painter.PainterSupport;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;
import java.awt.*;

/**
 * Custom UI for {@link JCheckBoxMenuItem} component.
 *
 * @author Mikle Garin
 */
public class WebCheckBoxMenuItemUI extends BasicCheckBoxMenuItemUI
{
    /**
     * Returns an instance of the {@link WebCheckBoxMenuItemUI} for the specified component.
     * This tricky method is used by {@link UIManager} to create component UIs when needed.
     *
     * @param c component that will use UI instance
     * @return instance of the {@link WebCheckBoxMenuItemUI}
     */
    @NotNull
    public static ComponentUI createUI ( @NotNull final JComponent c )
    {
        return new WebCheckBoxMenuItemUI ();
    }

    @Override
    public void installUI ( @NotNull final JComponent c )
    {
        super.installUI ( c );

        // Applying skin
        StyleManager.installSkin ( menuItem );
    }

    @Override
    public void uninstallUI ( @NotNull final JComponent c )
    {
        // Uninstalling applied skin
        StyleManager.uninstallSkin ( menuItem );

        // Uninstalling UI
        super.uninstallUI ( c );
    }

    @Override
    public boolean contains ( @NotNull final JComponent c, final int x, final int y )
    {
        return PainterSupport.contains ( c, this, x, y );
    }

    @Override
    public int getBaseline ( @NotNull final JComponent c, final int width, final int height )
    {
        return PainterSupport.getBaseline ( c, this, width, height );
    }

    @NotNull
    @Override
    public Component.BaselineResizeBehavior getBaselineResizeBehavior ( @NotNull final JComponent c )
    {
        return PainterSupport.getBaselineResizeBehavior ( c, this );
    }

    @Override
    public void paint ( @NotNull final Graphics g, @NotNull final JComponent c )
    {
        PainterSupport.paint ( g, c, this );
    }

    @Nullable
    @Override
    public Dimension getPreferredSize ( @NotNull final JComponent c )
    {
        return PainterSupport.getPreferredSize ( c );
    }
}