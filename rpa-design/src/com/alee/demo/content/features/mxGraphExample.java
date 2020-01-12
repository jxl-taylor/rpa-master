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

package com.alee.demo.content.features;

import com.alee.api.annotations.NotNull;
import com.alee.demo.api.example.*;
import com.alee.demo.api.example.wiki.WebLafWikiPage;
import com.alee.demo.api.example.wiki.WikiPage;
import com.alee.demo.skin.DemoStyles;
import com.alee.extended.layout.AlignLayout;
import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.overlay.FillOverlay;
import com.alee.laf.panel.WebPanel;
import com.alee.managers.style.StyleId;
import com.alee.utils.CollectionUtils;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

/**
 * @author Mikle Garin
 */
public class mxGraphExample extends AbstractPreviewExample
{
    @NotNull
    @Override
    public String getId ()
    {
        return "mxgraph";
    }

    @NotNull
    @Override
    public FeatureType getFeatureType ()
    {
        return FeatureType.settings;
    }

    @NotNull
    @Override
    public WikiPage getWikiPage ()
    {
        return new WebLafWikiPage( "How to use mxgraph" );
    }

    @NotNull
    @Override
    protected LayoutManager createPreviewLayout ()
    {
        return new AlignLayout();
    }

    @NotNull
    @Override
    protected List<Preview> createPreviews ()
    {
        return CollectionUtils.<Preview>asList (
                new MXGraphPreview ()
        );
    }

    /**
     * Easing graph preview.
     */
    protected class MXGraphPreview extends AbstractPreview
    {
        /**
         * Constructs new preview.
         */
        public MXGraphPreview ()
        {
            super ( mxGraphExample.this, "mxgraph", FeatureState.release );
        }

        @NotNull
        @Override
        protected JComponent createPreview ( @NotNull final List<Preview> previews, final int index )
        {
            // Preview panel
            final WebPanel preview = new WebPanel ( DemoStyles.previewsPanel, new VerticalFlowLayout( 0, 0, true, true ));

            mxGraph graph = new mxGraph();
            Object parent = graph.getDefaultParent();

            graph.getModel().beginUpdate();
            try
            {
                Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
                        30);
                Object v2 = graph.insertVertex(parent, null, "World!", 1240, 1050,
                        80, 30);
                graph.insertEdge(parent, null, "Edge", v1, v2);
            }
            finally
            {
                graph.getModel().endUpdate();
            }

            mxGraphComponent graphComponent = new mxGraphComponent(graph);
            Border js = BorderFactory.createEmptyBorder();
            graphComponent.setBorder(js);
            graphComponent.setMinimumSize(new Dimension(1000, 800));

            preview.add(graphComponent, BorderLayout.CENTER);

            return preview;
        }

        @Override
        public void applyEnabled ( final boolean enabled )
        {
            /**
             * Not available for this example.
             */
        }
    }

}
