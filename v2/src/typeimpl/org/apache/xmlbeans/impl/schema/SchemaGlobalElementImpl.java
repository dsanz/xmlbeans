/*
* The Apache Software License, Version 1.1
*
*
* Copyright (c) 2003 The Apache Software Foundation.  All rights 
* reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions
* are met:
*
* 1. Redistributions of source code must retain the above copyright
*    notice, this list of conditions and the following disclaimer. 
*
* 2. Redistributions in binary form must reproduce the above copyright
*    notice, this list of conditions and the following disclaimer in
*    the documentation and/or other materials provided with the
*    distribution.
*
* 3. The end-user documentation included with the redistribution,
*    if any, must include the following acknowledgment:  
*       "This product includes software developed by the
*        Apache Software Foundation (http://www.apache.org/)."
*    Alternately, this acknowledgment may appear in the software itself,
*    if and wherever such third-party acknowledgments normally appear.
*
* 4. The names "Apache" and "Apache Software Foundation" must 
*    not be used to endorse or promote products derived from this
*    software without prior written permission. For written 
*    permission, please contact apache@apache.org.
*
* 5. Products derived from this software may not be called "Apache 
*    XMLBeans", nor may "Apache" appear in their name, without prior 
*    written permission of the Apache Software Foundation.
*
* THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
* OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
* ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
* SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
* LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
* USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
* OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
* OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
* SUCH DAMAGE.
* ====================================================================
*
* This software consists of voluntary contributions made by many
* individuals on behalf of the Apache Software Foundation and was
* originally based on software copyright (c) 2000-2003 BEA Systems 
* Inc., <http://www.bea.com/>. For more information on the Apache Software
* Foundation, please see <http://www.apache.org/>.
*/

package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;
import javax.xml.namespace.QName;

import java.util.LinkedHashSet;
import java.util.Set;

public class SchemaGlobalElementImpl extends SchemaLocalElementImpl
        implements SchemaGlobalElement
{
    private Set _sgMembers = new LinkedHashSet();
    private static final QName[] _namearray = new QName[0];
    private boolean _finalExt;
    private boolean _finalRest;
    private SchemaTypeSystem _typeSystem;
    private String _filename;
    // private XmlObject _parseObject; now inherited from base
    private String _parseTNS;
    private boolean _chameleon;
    private SchemaGlobalElement.Ref _sg;

    public SchemaGlobalElementImpl(SchemaTypeSystem typeSystem)
    {
        _typeSystem = typeSystem;
    }

    public SchemaTypeSystem getTypeSystem()
    {
        return _typeSystem;
    }

    public String getSourceName()
    {
        return _filename;
    }

    public void setFilename(String filename)
    {
        _filename = filename;
    }

    void setFinal(boolean finalExt, boolean finalRest)
    {
        mutate(); _finalExt = finalExt; _finalRest = finalRest;
    }

    public int getComponentType()
    {
        return SchemaComponent.ELEMENT;
    }

    public SchemaGlobalElement substitutionGroup()
    {
        return _sg == null ? null : _sg.get();
    }

    public void setSubstitutionGroup(SchemaGlobalElement.Ref sg) 
    {
        _sg = sg;
    }

    public QName[] substitutionGroupMembers()
    {
        return (QName[])_sgMembers.toArray(_namearray);
    }

    public void addSubstitutionGroupMember(QName name)
    {
        mutate(); _sgMembers.add(name);
    }


    public boolean finalExtension()
    {
        return _finalExt;
    }

    public boolean finalRestriction()
    {
        return _finalRest;
    }

    public void setParseContext(XmlObject parseObject, String targetNamespace, boolean chameleon)
    {
        _parseObject = parseObject;
        _parseTNS = targetNamespace;
        _chameleon = chameleon;
    }

    public XmlObject getParseObject()
        { return _parseObject; }

    public String getTargetNamespace()
        { return _parseTNS; }

    public String getChameleonNamespace()
        { return _chameleon ? _parseTNS : null; }

    private SchemaGlobalElement.Ref _selfref = new SchemaGlobalElement.Ref(this);

    public SchemaGlobalElement.Ref getRef()
        { return _selfref; }

    public SchemaComponent.Ref getComponentRef()
        { return getRef(); }
}